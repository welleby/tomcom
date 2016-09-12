package org.welleby.tomcom.messages;

import java.util.List;

public interface MessageTransformer {
	public AbstractMessage getMessage(MessageType msgType, Object data) throws MessageTransformerException;
	public List<Byte> getBytes(AbstractMessage message) throws MessageTransformerException;
}
