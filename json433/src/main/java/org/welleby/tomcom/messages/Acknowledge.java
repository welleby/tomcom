package org.welleby.tomcom.messages;

import java.util.ArrayList;
import java.util.List;

import org.welleby.tomcom.messages.masks.HeaderBitMask;

import com.google.common.primitives.Bytes;
import com.google.common.primitives.Longs;

public class Acknowledge extends AbstractMessage {
	public Acknowledge() {
		super(MessageType.ACKNOWLEDGE);
	}
	public static Acknowledge createAcknowledge(Header message) {
		Acknowledge ack = new Acknowledge();
		ack.setClientId(message.getClientId());
		ack.setComponentId(message.getClientId());
		ack.setSequenceNumber(message.getSequenceNumber());
		ack.setUserId(message.getUserId());
		return ack;
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
