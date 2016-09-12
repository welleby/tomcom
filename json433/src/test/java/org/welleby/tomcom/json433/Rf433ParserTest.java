package org.welleby.tomcom.json433;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.welleby.tomcom.json433.messages.Acknowledge;
import org.welleby.tomcom.json433.messages.MessageParsingException;

public class Rf433ParserTest {
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
	public void parseAcknowledge() throws MessageParsingException {
		
		Rf433Parser.getMessage(input);
	}
}
