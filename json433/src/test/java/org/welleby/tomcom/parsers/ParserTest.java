package org.welleby.tomcom.parsers;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.welleby.tomcom.messages.Acknowledge;
import org.welleby.tomcom.messages.MessageParsingException;
import org.welleby.tomcom.parsers.Parser;

public class ParserTest {
	private List<Byte> input;
	
	@Before
	public void beforeParseAcknowledge() throws MessageParsingException {
		Acknowledge ack = new Acknowledge();
		ack.setClientId(10);
		ack.setComponentId(4);
		ack.setSequenceNumber(1);
		input = ack.getBytes();
	}
	
	@Test
	public void acknowledgeBytes2Msg_Test() throws MessageParsingException {
		Parser.getMessage(input);
	}
}
