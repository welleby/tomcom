package org.welleby.tomcom.transformers;

import java.util.List;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.Acknowledge;
import org.welleby.tomcom.messages.MessageParsingException;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;
import org.welleby.tomcom.messages.masks.HeaderBitMask;

public class AcknowledgeTransformer implements MessageTransformer {

	@Override
	public AbstractMessage getMessage(MessageType msgType, List<Byte> bytes) throws MessageTransformerException {
		if(msgType!=MessageType.ACKNOWLEDGE)
			throw new MessageTransformerException("Invalid message type");
		
		if(bytes==null || bytes.size()!=3)
			throw new MessageTransformerException("Invalid amount of bytes");
		
		Acknowledge ack = new Acknowledge();

		try {
			long clientId = HeaderBitMask.getValue(bytes, HeaderBitMask.CLIENT_ID);
			//long msgType = HeaderBitMask.getValue(bytes, HeaderBitMask.MESSAGE_TYPE);
			long seq = HeaderBitMask.getValue(bytes, HeaderBitMask.SEQUENCE_NUM);
			long componentId = HeaderBitMask.getValue(bytes, HeaderBitMask.COMPONENT_ID);
			
			ack.setClientId(clientId);
			ack.setSequenceNumber(seq);
			ack.setComponentId(componentId);
		} catch (MessageParsingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
