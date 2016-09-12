package org.welleby.tomcom.transformers;

import java.util.List;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageParsingException;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;

public class AcknowledgeTransformer implements MessageTransformer {

	@Override
	public AbstractMessage getMessage(MessageType msgType, List<Byte> bytes) throws MessageTransformerException {
		if(msgType!=MessageType.ACKNOWLEDGE)
			throw new MessageTransformerException("Invalid message type");
		return null;
	}

	@Override
	public List<Byte> getBytes(AbstractMessage message) throws MessageTransformerException {
		try {
			return message.getBytes();
		} catch (MessageParsingException e) {
			throw new MessageTransformerException("Could not get bytes from message", e);
		}
	}

}
