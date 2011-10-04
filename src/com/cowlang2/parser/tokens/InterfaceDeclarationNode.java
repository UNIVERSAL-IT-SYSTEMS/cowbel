package com.cowlang2.parser.tokens;

import java.util.List;
import com.cowlang2.parser.core.Location;

public class InterfaceDeclarationNode extends ExpressionNode
{
	public InterfaceDeclarationNode(Location start, Location end,
			IdentifierNode name, TypexDeclarationNode typeparams,
			List<MethodDeclarationNode> methods)
    {
		super(start, end);
		addChild(name);
		addChild(typeparams);
		addChildren(methods);
    }	
}
