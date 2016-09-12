package org.welleby.tomcom.json433;

import java.util.List;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;

public class Rf433Parser {
	private static Rf433MessageTransformer transformer = new Rf433MessageTransformer();
	
	public static AbstractMessage getMessage(List<Byte> bytes) throws MessageParsingException {
		
		long clientId = bytes.get(0) & BitMasks.CLIENT_ID.getMask();
		int sequenceNumber = bytes.get(1) & BitMasks.SEQUENCE_NUM.getMask();
		MessageType messageType = getMessageType(bytes);
		
		try {
			return transformer.getMessage(messageType, bytes.toArray());
		} catch (MessageTransformerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static MessageType getMessageType(List<Byte> bytes) throws MessageParsingException{
		if(bytes.size()<2)
			throw new MessageParsingException("Incomplete message. To few bytes.");
		
		int telegramNumber = bytes.get(1) & BitMasks.MESSAGE_TYPE.getMask();
		MessageType messageType = MessageType.parse(telegramNumber);
		return messageType;
	}
}
