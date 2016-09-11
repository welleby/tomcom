package org.welleby.tomcom.json433;

import java.util.List;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageType;

public class Rf433Parser {
	
	public static AbstractMessage getMessage(List<Byte> bytes) throws MessageParsingException {
		if(bytes.size()<2)
			throw new MessageParsingException("Incomplete message. To few bytes.");
		
		long clientId = bytes.get(0) & BitMasks.CLIENT_ID.getMask();
		int telegramNumber = bytes.get(1) & BitMasks.MESSAGE_TYPE.getMask();
		int sequenceNumber = bytes.get(1) & BitMasks.SEQUENCE_NUM.getMask();
		
		MessageType messageType = MessageType.parse(telegramNumber);
		
		return null;
	}
}
