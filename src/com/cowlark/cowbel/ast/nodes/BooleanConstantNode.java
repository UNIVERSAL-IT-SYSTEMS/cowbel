package com.cowlark.cowbel.ast.nodes;

import com.cowlark.cowbel.ast.Visitor;
import com.cowlark.cowbel.errors.CompilationException;
import com.cowlark.cowbel.parser.core.Location;

public class BooleanConstantNode extends ExpressionLiteralNode
{
	private boolean _value;
	
	public BooleanConstantNode(Location start, Location end, boolean value)
    {
        super(start, end);
        _value = value;
    }
	
	public boolean getValue()
	{
		return _value;
	}
	
	@Override
	public String getShortDescription()
	{
	    return Boolean.toString(_value);
	}
	
	@Override
	public void visit(Visitor visitor) throws CompilationException
	{
		visitor.visit(this);
	}
}