package org.welleby.tomcom.messages;

import java.util.List;

public abstract class AbstractMessage extends Header {

	public AbstractMessage(MessageType messageType) {
		super(messageType);
	}
	
	public abstract List<Byte> getBytes() throws MessageParsingException;
	public abstract AbstractMessage getMessage() throws MessageParsingException;

}
