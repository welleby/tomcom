package org.welleby.tomcom.parsers;

import java.util.List;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.masks.HeaderBitMask;
import org.welleby.tomcom.messages.MessageParsingException;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;
import org.welleby.tomcom.transformers.MessageTransformerImpl;

public class Parser {
	private static MessageTransformerImpl transformer = new MessageTransformerImpl();
	
	public static AbstractMessage getMessage(List<Byte> bytes) throws MessageParsingException {
		
		MessageType messageType = getMessageType(bytes);
		
		try {
			return transformer.getMessage(messageType, bytes);
		} catch (MessageTransformerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static MessageType getMessageType(List<Byte> bytes) throws MessageParsingException{
		if(bytes.size()<2)
			throw new MessageParsingException("Incomplete message. To few bytes.");
		
		long telegramNumber = HeaderBitMask.getValue(bytes, HeaderBitMask.MESSAGE_TYPE);
		MessageType messageType = MessageType.parse(telegramNumber);
		return messageType;
	}
}
