package org.welleby.tomcom.transformers;

import java.util.List;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;

public interface MessageTransformer {
	public AbstractMessage getMessage(MessageType msgType, List<Byte> bytes) throws MessageTransformerException;
	public List<Byte> getBytes(AbstractMessage message) throws MessageTransformerException;
}
