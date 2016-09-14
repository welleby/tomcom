package org.welleby.tomcom.messages;

import java.util.List;

public class Acknowledge extends AbstractMessage {
	public Acknowledge() {
		super(MessageType.ACKNOWLEDGE);
	}
	public static Acknowledge createAcknowledge(Header header) {
		Acknowledge ack = new Acknowledge();
		ack.setHeader(header);
		return ack;
	}
	
	public List<Byte> getBytes() throws MessageParsingException{
		return super.getBytes();
	}
}
