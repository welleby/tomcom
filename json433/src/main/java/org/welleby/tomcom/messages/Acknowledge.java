package org.welleby.tomcom.messages;

public class Acknowledge extends AbstractMessage {
	public Acknowledge() {
		super(MessageType.ACKNOWLEDGE);
	}
	public static Acknowledge createAcknowledge(Header message) {
		Acknowledge ack = new Acknowledge();
		ack.setClientId(message.getClientId());
		ack.setComponentId(message.getClientId());
		ack.setSequenceNumber(message.getSequenceNumber());
		ack.setUserId(message.getUserId());
		return ack;
	}
}
