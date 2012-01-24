package com.cowlark.cowbel.ast.nodes;

import com.cowlark.cowbel.ast.HasSymbol;
import com.cowlark.cowbel.ast.Visitor;
import com.cowlark.cowbel.errors.CompilationException;
import com.cowlark.cowbel.parser.core.Location;
import com.cowlark.cowbel.symbols.Symbol;

public class VarReferenceNode extends ExpressionNode implements HasSymbol
{
	private Symbol _symbol;
	
	public VarReferenceNode(Location start, Location end, IdentifierNode name)
    {
		super(start, end);
		addChild(name);
    }
	
	@Override
	public String getShortDescription()
	{
		Symbol s = getSymbol();
		if (s == null)
			return getText();
		else
			return s.toString();
	}
	
	public IdentifierNode getVariableName()
	{
		return (IdentifierNode) getChild(0);
	}
	
	@Override
	public void visit(Visitor visitor) throws CompilationException
	{
		visitor.visit(this);
	}
	
	@Override
	public Symbol getSymbol()
	{
	    return _symbol;
	}
	
	@Override
	public void setSymbol(Symbol symbol)
	{
	    _symbol = symbol;	    
	}
}