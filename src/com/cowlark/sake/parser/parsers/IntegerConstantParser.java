package com.cowlark.sake.parser.parsers;

import com.cowlark.sake.ast.nodes.IntegerConstantNode;
import com.cowlark.sake.parser.core.Location;
import com.cowlark.sake.parser.core.MutableLocation;
import com.cowlark.sake.parser.core.ParseResult;
import com.cowlark.sake.parser.errors.MalformedIntegerConstant;

public class IntegerConstantParser extends Parser
{
	@Override
	protected ParseResult parseImpl(Location location)
	{
		boolean negated = false;
		
		StringBuilder sb = new StringBuilder();
		MutableLocation end = new MutableLocation(location);
		int c = end.codepointAtOffset(0);
		if (c == '-')
		{
			negated = true;
			end.advance();
		}
			
		for (;;)
		{
			c = end.codepointAtOffset(0);
			
			if (!Character.isDigit(c))
				break;
			
			sb.append((char) c);
			end.advance();
		}

		long value;
		try
		{
			value = Long.parseLong(sb.toString());
		}
		catch (NumberFormatException e)
		{
			return new MalformedIntegerConstant(location);
		}
		
		if (negated)
			value = -value;
		
		return new IntegerConstantNode(location, end, value);
	}
}
