package org.welleby.tomcom.messages;

public abstract class AbstractMessage extends Header {

	public AbstractMessage(MessageType messageType) {
		super(messageType);
	}

}
