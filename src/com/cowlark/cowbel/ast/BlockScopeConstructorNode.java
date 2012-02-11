/* © 2012 David Given
 * This file is made available under the terms of the two-clause BSD
 * license. See the file COPYING.BSD in the distribution directory for the
 * full license text.
 */

package com.cowlark.cowbel.ast;

import com.cowlark.cowbel.errors.CompilationException;
import com.cowlark.cowbel.parser.core.Location;

public class BlockScopeConstructorNode extends AbstractScopeConstructorNode
{
	public BlockScopeConstructorNode(Location start, Location end)
    {
        super(start, end);
    }

	public BlockScopeConstructorNode(Location start, Location end, AbstractStatementNode child)
    {
        super(start, end, child);
    }

	@Override
	public void visit(ASTVisitor visitor) throws CompilationException
	{
		visitor.visit(this);
	}
}