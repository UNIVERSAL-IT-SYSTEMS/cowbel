package com.cowlark.sake.methods;

import com.cowlark.sake.types.IntegerType;

public class StringSizeMethod extends Method
{
	public StringSizeMethod()
    {
		setSignature("string.size.0", "string.size");
		setReturnType(IntegerType.create());
		setArgumentTypes();
    }
}
