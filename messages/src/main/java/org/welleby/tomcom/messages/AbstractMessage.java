package org.welleby.tomcom.messages;

import java.util.ArrayList;
import java.util.List;

import com.google.common.primitives.Bytes;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;

public abstract class AbstractMessage {
	private Header header;

	public AbstractMessage(MessageType msgType) {
		this.setHeader(new Header(msgType));
	}
	public List<Byte> getBytes() throws MessageParsingException{
		return getHeader().getBytes();
	}
	
	public List<Byte> toBytes(Object value) throws MessageParsingException{
		List<Byte> result = new ArrayList<>();
		if(value instanceof Byte){
			result.add((Byte)value);
		}
		else if(value instanceof Short){
			byte[] byteArray = Shorts.toByteArray((Short)value);
			result.addAll(Bytes.asList(byteArray));
		}
		else if(value instanceof Integer){
			byte[] byteArray = Ints.toByteArray((Integer)value);
			result.addAll(Bytes.asList(byteArray));
		}
		else if(value instanceof Long){
			byte[] byteArray = Longs.toByteArray((Long)value);
			result.addAll(Bytes.asList(byteArray));
		}
		
		if(result.size()==0)
			throw new MessageParsingException("Could not convert value to bytes " + value);
		
		return result;
	}
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	
	public Long getClientId() {
		return getHeader().getClientId();
	}
	public void setClientId(long clientId) {
		header.setClientId(clientId);
	}
	public Long getSequenceNumber() {
		return getHeader().getSequenceNumber();
	}
	public void setSequenceNumber(long sequenceNumber) {
		header.setSequenceNumber(sequenceNumber);
	}
	public Long getUserId() {
		return getHeader().getUserId();
	}
	public void setUserId(long userId) {
		header.setUserId(userId);
	}
	public Long getComponentId() {
		return getHeader().getComponentId();
	}
	public void setComponentId(long componentId) {
		header.setComponentId(componentId);
	}
}
