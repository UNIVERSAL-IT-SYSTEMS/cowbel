package com.cowlark.cowbel.ast.nodes;

import com.cowlark.cowbel.Label;
import com.cowlark.cowbel.ast.HasLabel;
import com.cowlark.cowbel.ast.Visitor;
import com.cowlark.cowbel.errors.CompilationException;
import com.cowlark.cowbel.parser.core.Location;

public class LabelStatementNode extends StatementNode implements HasLabel
{
	private Label _label;
	
	public LabelStatementNode(Location start, Location end, IdentifierNode name)
    {
		super(start, end);
		addChild(name);
    }
	
	@Override
	public String getShortDescription()
	{
		if (_label == null)
			return getText();
		else
			return _label.toString();
	}
	
	public IdentifierNode getLabelName()
	{
		return (IdentifierNode) getChild(0);
	}
	
	@Override
	public void visit(Visitor visitor) throws CompilationException
	{
		visitor.visit(this);
	}
	
	@Override
	public Label getLabel()
	{
	    return _label;
	}
	
	@Override
	public void setLabel(Label label)
	{
	    _label = label;	    
	}
}