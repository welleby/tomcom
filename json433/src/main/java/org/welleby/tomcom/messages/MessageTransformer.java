package org.welleby.tomcom.messages;

public interface MessageTransformer {
	public AbstractMessage getMessage(MessageType msgType, Object data) throws MessageTransformerException;
}
