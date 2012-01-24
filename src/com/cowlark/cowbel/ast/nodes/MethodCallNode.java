package com.cowlark.cowbel.ast.nodes;

import java.util.ArrayList;
import java.util.List;
import com.cowlark.cowbel.ast.Visitor;
import com.cowlark.cowbel.errors.CompilationException;
import com.cowlark.cowbel.methods.Method;
import com.cowlark.cowbel.parser.core.Location;

public class MethodCallNode extends ExpressionNode
{
	private Method _method;
	
	public MethodCallNode(Location start, Location end, ExpressionNode object,
			IdentifierNode method, ExpressionNode... arguments)
    {
		super(start, end);
		addChild(object);
		addChild(method);
		for (ExpressionNode n : arguments)
			addChild(n);
    }
	
	public MethodCallNode(Location start, Location end, ExpressionNode object,
			IdentifierNode method, List<ExpressionNode> arguments)
	{
		super(start, end);
		addChild(object);
		addChild(method);
		for (ExpressionNode n : arguments)
			addChild(n);
	}
	
	public Method getMethod()
	{
		return _method;
	}
	
	public void setMethod(Method method)
	{
		_method = method;
	}
	
	public ExpressionNode getMethodReceiver()
	{
		return (ExpressionNode) getChild(0);
	}
	
	public IdentifierNode getMethodIdentifier()
	{
		return (IdentifierNode) getChild(1);
	}
	
	private ArrayList<ExpressionNode> _arguments;
	public List<ExpressionNode> getMethodArguments()
	{
		if (_arguments == null)
		{
			_arguments = new ArrayList<ExpressionNode>();
			for (int i = 2; i < getNumberOfChildren(); i++)
				_arguments.add((ExpressionNode) getChild(i));
		}
		return _arguments;
	}
	
	public int getMethodArgumentCount()
	{
		return getNumberOfChildren() - 2;
	}
	
	@Override
	public String getShortDescription()
	{
	    return getMethodIdentifier().getText();
	}
	
	@Override
	public void visit(Visitor visitor) throws CompilationException
	{
		visitor.visit(this);
	}
}