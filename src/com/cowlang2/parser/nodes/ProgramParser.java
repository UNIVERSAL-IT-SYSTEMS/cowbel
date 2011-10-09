package com.cowlang2.parser.nodes;

import java.util.ArrayList;
import com.cowlang2.parser.core.Location;
import com.cowlang2.parser.core.ParseResult;
import com.cowlang2.parser.tokens.StatementListNode;
import com.cowlang2.parser.tokens.StatementNode;

public class ProgramParser extends Parser
{
	@Override
	protected ParseResult parseImpl(Location location)
	{
		ArrayList<StatementNode> statements = new ArrayList<StatementNode>();
		
		Location n = location;
		for (;;)
		{
			ParseResult pr = EOFParser.parse(n);
			if (pr.success())
				break;
			
			pr = StatementParser.parse(n);
			if (pr.failed())
				return pr;
			
			statements.add((StatementNode) pr);
			n = pr.end();
		}
		
		return new StatementListNode(location, n, statements); 
	}
}
