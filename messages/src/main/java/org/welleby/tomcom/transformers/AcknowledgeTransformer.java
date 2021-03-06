package org.welleby.tomcom.transformers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.Acknowledge;
import org.welleby.tomcom.messages.MessageParsingException;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;

public class AcknowledgeTransformer extends MessageTransformer {
	private static Logger logger = LogManager.getLogger(AcknowledgeTransformer.class);
	
	public AcknowledgeTransformer() {
		super(MessageType.ACKNOWLEDGE);
	}


	@Override
	public AbstractMessage getMessage(MessageType msgType, List<Byte> bytes) throws MessageTransformerException {
		validateBytes(msgType, bytes);
		Acknowledge ack = new Acknowledge();
		ack.setHeader(getHeader(msgType, bytes));
		return ack;
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
