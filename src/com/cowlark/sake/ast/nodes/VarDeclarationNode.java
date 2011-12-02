package com.cowlark.sake.ast.nodes;

import com.cowlark.sake.ast.Visitor;
import com.cowlark.sake.errors.CompilationException;
import com.cowlark.sake.parser.core.Location;

public class VarDeclarationNode extends StatementNode
{
	public VarDeclarationNode(Location start, Location end,
			IdentifierNode identifier, TypeNode type)
    {
		super(start, end);
		addChild(identifier);
		addChild(type);
    }
	
	@Override
	public String getShortDescription()
	{
	    return getText();
	}
	
	@Override
	public void visit(Visitor visitor) throws CompilationException
	{
		visitor.visit(this);
	}
}