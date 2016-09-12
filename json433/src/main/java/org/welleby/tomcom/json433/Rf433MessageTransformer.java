package org.welleby.tomcom.json433;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.welleby.tomcom.json433.handlers.AcknowledgeHandler;
import org.welleby.tomcom.json433.handlers.MessageHandler;
import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageTransformer;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;

public class Rf433MessageTransformer implements MessageTransformer {

	private Map<MessageType,MessageHandler> handlerMap = new HashMap<>();
	
	public Rf433MessageTransformer() {
		handlerMap.put(MessageType.ACKNOWLEDGE,	new AcknowledgeHandler());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public AbstractMessage getMessage(MessageType msgType, Object data) throws MessageTransformerException {
		List<Byte> bytes;
		try {
			bytes = (List<Byte>)data;
		} catch (ClassCastException e) {
			throw new MessageTransformerException("Unexpected data",e);
		}
		
		return handlerMap.get(msgType).handleMessage(bytes);
	}

}
