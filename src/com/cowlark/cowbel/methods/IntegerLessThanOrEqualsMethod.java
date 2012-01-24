package com.cowlark.cowbel.methods;

import com.cowlark.cowbel.types.BooleanType;
import com.cowlark.cowbel.types.IntegerType;

public class IntegerLessThanOrEqualsMethod extends Method
{
	public IntegerLessThanOrEqualsMethod()
    {
		setSignature("integer.<=.1", "integer._le");
		setReturnType(BooleanType.create());
		setArgumentTypes(IntegerType.create());
    }
}