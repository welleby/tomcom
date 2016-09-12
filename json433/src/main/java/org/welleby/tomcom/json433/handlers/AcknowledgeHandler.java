package org.welleby.tomcom.json433.handlers;

import java.util.List;

import org.welleby.tomcom.json433.messages.Acknowledge;
import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageTransformerException;

public class AcknowledgeHandler implements MessageHandler {

	@Override
	public AbstractMessage handleMessage(List<Byte> bytes) throws MessageTransformerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Byte> handleMessage(AbstractMessage message) throws MessageTransformerException {
		if(!(message instanceof Acknowledge))
			throw new MessageTransformerException("Invalid message");
		return null;
	}

}
