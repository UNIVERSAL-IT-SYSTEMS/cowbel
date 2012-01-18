package com.cowlark.sake.instructions;

import com.cowlark.sake.BasicBlock;

public class InstructionVisitor
{
	public void visit(BasicBlock bb)
	{
	}
	
	public void visit(Instruction insn)
	{
	}
	
	public void visit(FunctionExitInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(GotoInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(IfInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(SetReturnValueInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(GetUpvalueInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(SetUpvalueInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(GetLocalInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(SetLocalInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(MethodCallInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(DirectFunctionCallInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(ArrayConstructorInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(BooleanConstantInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(StringConstantInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(IntegerConstantInstruction insn)
	{
		visit((Instruction) insn);
	}
	
	public void visit(DiscardInstruction insn)
	{
		visit((Instruction) insn);
	}
	
}
