package org.welleby.tomcom.transformers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;

public class MessageTransformerImpl implements MessageTransformer {

	private Map<MessageType, MessageTransformer> handlerMap = new HashMap<>();
	
	public MessageTransformerImpl() {
		handlerMap.put(MessageType.ACKNOWLEDGE,	new AcknowledgeTransformer());
	}
	
	@Override
	public AbstractMessage getMessage(MessageType msgType,List<Byte> bytes) throws MessageTransformerException {
		if(!handlerMap.containsKey(msgType))
			throw new MessageTransformerException("Invalid messageType");
		return handlerMap.get(msgType).getMessage(msgType, bytes);
	}

	@Override
	public List<Byte> getBytes(AbstractMessage data) throws MessageTransformerException {
		// TODO Auto-generated method stub
		return null;
	}

}
