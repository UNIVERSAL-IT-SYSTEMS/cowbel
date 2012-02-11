/* © 2012 David Given
 * This file is made available under the terms of the two-clause BSD
 * license. See the file COPYING.BSD in the distribution directory for the
 * full license text.
 */

package com.cowlark.cowbel.ast;

import com.cowlark.cowbel.errors.CompilationException;
import com.cowlark.cowbel.parser.core.Location;
import com.cowlark.cowbel.types.InferredType;
import com.cowlark.cowbel.types.Type;

public class InferredTypeNode extends AbstractTypeNode
{
	public InferredTypeNode(Location start, Location end)
    {
        super(start, end);
    }
	
	@Override
	public Type calculateType()
	{
		return InferredType.create();
	}
	
	@Override
	public void visit(ASTVisitor visitor) throws CompilationException
	{
		visitor.visit(this);
	}
}