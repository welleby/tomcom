package org.welleby.tomcom.json433.transformers;

import java.util.List;

import org.welleby.tomcom.json433.messages.Acknowledge;
import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageTransformer;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;

public class AcknowledgeHandler implements MessageTransformer {

	@Override
	public AbstractMessage getMessage(MessageType msgType, Object data) throws MessageTransformerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Byte> getBytes(AbstractMessage message) throws MessageTransformerException {
		if(!(message instanceof Acknowledge))
			throw new MessageTransformerException("Invalid message");
		return null;
	}



}
