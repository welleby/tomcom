package org.welleby.tomcom.transformers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.Header;
import org.welleby.tomcom.messages.MessageParsingException;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;
import org.welleby.tomcom.messages.masks.HeaderBitMask;

public abstract class MessageTransformer {
	private static Logger logger = LogManager.getLogger(MessageTransformer.class);
	private MessageType transformerType;
	public MessageTransformer(MessageType msgType){
		this.transformerType = msgType;
	}
	public abstract AbstractMessage getMessage(MessageType msgType, List<Byte> bytes) throws MessageTransformerException;
	public abstract List<Byte> getBytes(AbstractMessage message) throws MessageTransformerException;
	protected void validateBytes(MessageType msgType, List<Byte> bytes) throws MessageTransformerException{
		if(msgType!=getTransformerType())
			throw new MessageTransformerException("Invalid message type");
		
		if(bytes==null || bytes.size()<4){
			logger.error("Expected at least 3 bytes. Got " + bytes==null ? "null" : bytes.size());
			throw new MessageTransformerException("To few bytes");
		}
	}
	protected Header getHeader(MessageType msgType, List<Byte> bytes) throws MessageTransformerException{
		validateBytes(msgType, bytes);
		
		Header header = new Header(msgType);

		try {
			long clientId = HeaderBitMask.getValue(bytes, HeaderBitMask.CLIENT_ID);
			//long msgType = HeaderBitMask.getValue(bytes, HeaderBitMask.MESSAGE_TYPE);
			long seq = HeaderBitMask.getValue(bytes, HeaderBitMask.SEQUENCE_NUM);
			long componentId = HeaderBitMask.getValue(bytes, HeaderBitMask.COMPONENT_ID);
			
			header.setClientId(clientId);
			header.setSequenceNumber(seq);
			header.setComponentId(componentId);
		} catch (MessageParsingException e) {
			logger.error("Could not setup HeaderBytes");
			throw new MessageTransformerException("Could not setup HeaderBytes",e);
		}
		return header;
	}
	public MessageType getTransformerType() {
		return transformerType;
	}
	public void setTransformerType(MessageType transformerType) {
		this.transformerType = transformerType;
	}
}
