/* © 2012 David Given
 * This file is made available under the terms of the two-clause BSD
 * license. See the file COPYING.BSD in the distribution directory for the
 * full license text.
 */

package com.cowlark.cowbel;

import com.cowlark.cowbel.ast.RecursiveVisitor;
import com.cowlark.cowbel.ast.nodes.AbstractScopeConstructorNode;
import com.cowlark.cowbel.ast.nodes.AbstractScopeConstructorNode.ScopeType;
import com.cowlark.cowbel.ast.nodes.BlockScopeConstructorNode;
import com.cowlark.cowbel.ast.nodes.DoWhileStatementNode;
import com.cowlark.cowbel.ast.nodes.FunctionDefinitionNode;
import com.cowlark.cowbel.ast.nodes.FunctionScopeConstructorNode;
import com.cowlark.cowbel.ast.nodes.IfElseStatementNode;
import com.cowlark.cowbel.ast.nodes.IfStatementNode;
import com.cowlark.cowbel.ast.nodes.WhileStatementNode;
import com.cowlark.cowbel.errors.CompilationException;

public class ClassifyScopeKindsVisitor extends RecursiveVisitor
{
	@Override
	public void visit(IfStatementNode node) throws CompilationException
	{
		node.getPositiveStatement().setScopeType(ScopeType.SIGNIFICANT);
	    super.visit(node);
	}
	
	@Override
	public void visit(IfElseStatementNode node) throws CompilationException
	{
		node.getPositiveStatement().setScopeType(ScopeType.SIGNIFICANT);
		node.getNegativeStatement().setScopeType(ScopeType.SIGNIFICANT);
	    super.visit(node);
	}
	
	@Override
	public void visit(DoWhileStatementNode node) throws CompilationException
	{
	    node.getBodyStatement().setScopeType(ScopeType.SIGNIFICANT);
	    super.visit(node);
	}
	
	@Override
	public void visit(WhileStatementNode node) throws CompilationException
	{
	    node.getBodyStatement().setScopeType(ScopeType.SIGNIFICANT);
	    super.visit(node);
	}
	
	private void visit(AbstractScopeConstructorNode node)
			throws CompilationException
	{
		/* If this scope exports any symbols to scopes in a different function,
		 * it must be persistent (or bad stuff happens). */
		
		Function thisf = node.getFunction();
		for (AbstractScopeConstructorNode n : node.getExportedScopes())
		{
			if (n.getFunction() != thisf)
			{
				node.setScopeType(ScopeType.PERSISTENT);
				return;
			}
		}
	}
	
	@Override
	public void visit(BlockScopeConstructorNode node)
	        throws CompilationException
	{
	    visit((AbstractScopeConstructorNode) node);
	    super.visit(node);
	}
	
	@Override
	public void visit(FunctionScopeConstructorNode node)
	        throws CompilationException
	{
		node.setScopeType(ScopeType.SIGNIFICANT);
	    visit((AbstractScopeConstructorNode) node);
	    super.visit(node);
	}
	
	@Override
	public void visit(FunctionDefinitionNode node) throws CompilationException
	{
		AbstractScopeConstructorNode scope = node.getScope();
		scope.setScopeType(ScopeType.PERSISTENT);
		/* don't recurse */
	}
}
