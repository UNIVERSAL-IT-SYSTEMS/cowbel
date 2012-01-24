package com.cowlark.cowbel.ast.nodes;

import com.cowlark.cowbel.ast.Visitor;
import com.cowlark.cowbel.errors.CompilationException;
import com.cowlark.cowbel.parser.core.Location;

public class ReturnStatementNode extends StatementNode
{
	public ReturnStatementNode(Location start, Location end,
			ExpressionNode value)
    {
		super(start, end);
		addChild(value);
    }
	
	public ExpressionNode getValue()
	{
		return (ExpressionNode) getChild(0);
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