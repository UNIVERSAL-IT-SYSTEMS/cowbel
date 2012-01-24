package com.cowlark.cowbel.parser.parsers;

import com.cowlark.cowbel.ast.nodes.FunctionDefinitionNode;
import com.cowlark.cowbel.ast.nodes.FunctionHeaderNode;
import com.cowlark.cowbel.ast.nodes.FunctionScopeConstructorNode;
import com.cowlark.cowbel.ast.nodes.StatementNode;
import com.cowlark.cowbel.parser.core.Location;
import com.cowlark.cowbel.parser.core.ParseResult;

public class FunctionDefinitionParser extends Parser
{
	@Override
	protected ParseResult parseImpl(Location location)
	{
		ParseResult headerpr = FunctionHeaderParser.parse(location);
		if (headerpr.failed())
			return headerpr;

		ParseResult bodypr = ScopeConstructorParser.parse(headerpr.end());
		if (bodypr.failed())
			return bodypr;
		
		return new FunctionDefinitionNode(location, bodypr.end(),
				(FunctionHeaderNode) headerpr,
				new FunctionScopeConstructorNode(bodypr.start(), bodypr.end(),
						(StatementNode) bodypr));
	}
}