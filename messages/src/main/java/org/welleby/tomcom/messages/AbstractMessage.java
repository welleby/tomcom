package org.welleby.tomcom.messages;

import java.util.ArrayList;
import java.util.List;

import com.google.common.primitives.Bytes;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;

public abstract class AbstractMessage extends Header {

	public AbstractMessage(MessageType messageType) {
		super(messageType);
	}
	public abstract List<Byte> getBytes() throws MessageParsingException;
	
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
}
