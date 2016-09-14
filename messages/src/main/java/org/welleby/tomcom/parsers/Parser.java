package org.welleby.tomcom.parsers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageParsingException;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;
import org.welleby.tomcom.transformers.AcknowledgeTransformer;
import org.welleby.tomcom.transformers.MessageTransformer;
import org.welleby.tomcom.transformers.SensorReportTransformer;
import org.welleby.tomcom.messages.masks.HeaderBitMask;

public class Parser {

	private static Map<MessageType, MessageTransformer> handlerMap = new HashMap<>();
	
	public Parser() {
		handlerMap.put(MessageType.ACKNOWLEDGE, new AcknowledgeTransformer());
		handlerMap.put(MessageType.SENSOR_REPORT, new SensorReportTransformer());
	}
	public static AbstractMessage getMessage(List<Byte> bytes) throws MessageTransformerException, MessageParsingException {
		
		MessageType msgType = getMessageType(bytes);
		
		if(!handlerMap.containsKey(msgType))
			throw new MessageTransformerException("Invalid messageType");
		return handlerMap.get(msgType).getMessage(msgType, bytes);
		
	}
		
	private static MessageType getMessageType(List<Byte> bytes) throws MessageParsingException{
		if(bytes.size()<2)
			throw new MessageParsingException("Incomplete message. To few bytes.");
		
		long telegramNumber = HeaderBitMask.getValue(bytes, HeaderBitMask.MESSAGE_TYPE);
		MessageType messageType = MessageType.parse(telegramNumber);
		return messageType;
	}

}

