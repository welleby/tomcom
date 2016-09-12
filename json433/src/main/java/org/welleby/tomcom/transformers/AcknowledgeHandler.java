package org.welleby.tomcom.transformers;

import java.util.List;

import org.welleby.tomcom.messages.Acknowledge;
import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageTransformer;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;

public class AcknowledgeHandler implements MessageTransformer {

	@Override
	public AbstractMessage getMessage(MessageType msgType, List<Byte> bytes) throws MessageTransformerException {
		if(msgType!=MessageType.ACKNOWLEDGE)
			throw new MessageTransformerException("Invalid message type");
		
		
		
		return null;
	}

	@Override
	public List<Byte> getBytes(AbstractMessage message) throws MessageTransformerException {
		if(!(message instanceof Acknowledge))
			throw new MessageTransformerException("Invalid message");
		
		
		return null;
	}

}
