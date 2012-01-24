package com.cowlark.cowbel.types;

public class VoidType extends PrimitiveType
{
	private static VoidType _instance =
		Type.canonicalise(new VoidType());
	
	public static VoidType create()
	{
		return _instance;
	}
	
	private VoidType()
    {
    }
	
	@Override
	public boolean isVoidType()
	{
		return true;
	}
	
	@Override
	public String getCanonicalTypeName()
	{
	    return "void";
	}
	
	@Override
	public void visit(TypeVisitor visitor)
	{
	    visitor.visit(this);	    
	}
}