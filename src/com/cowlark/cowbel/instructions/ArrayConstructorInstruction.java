/* © 2012 David Given
 * This file is made available under the terms of the two-clause BSD
 * license. See the file COPYING in the distribution directory for the
 * full license text.
 */

package com.cowlark.cowbel.instructions;

import java.util.List;
import com.cowlark.cowbel.ast.nodes.Node;
import com.cowlark.cowbel.symbols.Variable;

public class ArrayConstructorInstruction extends Instruction
{
	private List<Variable> _values;
	private Variable _outvar;
	
	public ArrayConstructorInstruction(Node node, List<Variable> values,
			Variable outvar)
    {
		super(node);
		_values = values;
		_outvar = outvar;
    }
	
	@Override
	protected String getInstructionName()
	{
	    return "ArrayConstructor";
	}
	
	@Override
	protected String getShortDescription()
	{
		return "values=" + varlist(_values) + " outvar=" + _outvar.toString();
	}
	
	public void visit(InstructionVisitor visitor)
	{
		visitor.visit(this);
	}
}
