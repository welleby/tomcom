package org.welleby.tomcom.json433.handlers;

import java.util.List;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageTransformerException;

public interface MessageHandler {
	public AbstractMessage handleMessage(List<Byte> bytes) throws MessageTransformerException;
	public List<Byte> handleMessage(AbstractMessage message) throws MessageTransformerException;
}
