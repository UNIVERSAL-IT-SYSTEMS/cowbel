/* © 2012 David Given
 * This file is made available under the terms of the two-clause BSD
 * license. See the file COPYING.BSD in the distribution directory for the
 * full license text.
 */

package com.cowlark.cowbel.types;

import com.cowlark.cowbel.ast.HasInputs;
import com.cowlark.cowbel.ast.IsMethod;
import com.cowlark.cowbel.ast.nodes.IdentifierNode;
import com.cowlark.cowbel.ast.nodes.Node;
import com.cowlark.cowbel.errors.CompilationException;
import com.cowlark.cowbel.methods.Method;

public class InferredType extends Type
{
	public static InferredType create()
	{
		return new InferredType();
	}
	
	private Type _realType;
	
	private InferredType()
    {
    }
	
	@Override
	public boolean isVoidType()
	{
		return getRealType().isVoidType();
	}
	
	@Override
	protected Type getRealType()
	{
		if (_realType == null)
			return this;
		return _realType;
	}
	
	@Override
	public String getCanonicalTypeName()
	{
		if (_realType != null)
			return _realType.getCanonicalTypeName();
	    return "α";
	}

	@Override
	public boolean isConcreteType()
	{
		if (_realType == null)
			return false;
		return _realType.isConcreteType();
	}

	@Override
	public void unifyWithImpl(Node node, Type other) throws CompilationException
	{
		if (_realType != null)
			_realType.unifyWith(node, other);
		else
		{
			assert(other != this);
			_realType = other;
		}
	}
	
	@Override
	public <T extends Node & IsMethod & HasInputs> Method lookupMethod(
	        T node, IdentifierNode id) throws CompilationException
	{
		assert(_realType != null);
		return _realType.lookupMethod(node, id);
	}
	
	@Override
	public void visit(TypeVisitor visitor)
	{
		assert(_realType != null);
		_realType.visit(visitor);
	}
}