package com.cowlark.sake.ast.nodes;

import com.cowlark.sake.CompilationException;
import com.cowlark.sake.ast.Visitor;
import com.cowlark.sake.parser.core.Location;

public class VariableReadNode extends ExpressionNode
{
	public VariableReadNode(Location start, Location end)
    {
		super(start, end);
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
