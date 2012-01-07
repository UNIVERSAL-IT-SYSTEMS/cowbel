package com.cowlark.sake.instructions;

import com.cowlark.sake.BasicBlock;
import com.cowlark.sake.ast.nodes.Node;

public class IfInstruction extends Instruction
{
	private BasicBlock _positive;
	private BasicBlock _negative;
	
	public IfInstruction(Node node, BasicBlock positive, BasicBlock negative)
    {
		super(node, 1);
		_positive = positive;
		_negative = negative;
    }
	
	public BasicBlock getPositiveTarget()
	{
		return _positive;
	}
	
	public BasicBlock getNegativeTarget()
	{
		return _negative;
	}

	@Override
	protected String getInstructionName()
	{
	    return "If";
	}
	
	@Override
	protected String getShortDescription()
	{
	    return "+"+_positive + " -"+_negative;
	}
	
	public void visit(InstructionVisitor visitor)
	{
		visitor.visit(this);
	}
}