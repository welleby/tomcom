package org.welleby.tomcom.messages;

import java.util.ArrayList;
import java.util.List;

import org.welleby.tomcom.messages.masks.HeaderBitMask;

import com.google.common.primitives.Bytes;
import com.google.common.primitives.Longs;

public class Header{
	private Long userId; //The unique User (not needed for small scale
	private Long clientId; //The RF-clientId
	private Long componentId; //The Id of the component on the client
	private Long sequenceNumber; //The sequence number of the particular message
	private final MessageType messageType; //The type of message

	public Header(MessageType messageType) {
		this.messageType = messageType;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public Long getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Long getComponentId() {
		return componentId;
	}
	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}
	public MessageType getMessageType() {
		return messageType;
	}
	
	public List<Byte> getBytes() throws MessageParsingException{
		List<Byte> result = new ArrayList<>();
		if(getUserId()!=null) {
			byte[] byteArray = Longs.toByteArray(getUserId());
			result.addAll(Bytes.asList(byteArray));
		}
		if(getClientId()==null)
			throw new MessageParsingException("Missing ClientId");
		if(getSequenceNumber()==null)
			throw new MessageParsingException("Missing SequenceNumber");
		if(getComponentId()==null)
			throw new MessageParsingException("Missing ComponentId");
		
		result.add(HeaderBitMask.getByte(getClientId(), HeaderBitMask.CLIENT_ID));
		byte seq = HeaderBitMask.getByte(getSequenceNumber(), HeaderBitMask.SEQUENCE_NUM);
		byte tgm = HeaderBitMask.getByte(getMessageType().getTgmNr(), HeaderBitMask.MESSAGE_TYPE);
		result.add((byte) (seq | tgm));
		result.add(HeaderBitMask.getByte(getComponentId(), HeaderBitMask.COMPONENT_ID));
			
		return result;
	}
}
