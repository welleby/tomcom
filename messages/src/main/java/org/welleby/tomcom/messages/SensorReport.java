package org.welleby.tomcom.messages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.primitives.Bytes;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;

public class SensorReport extends AbstractMessage{

	private Map<String,Object> values = new HashMap<>();
	
	public SensorReport() {
		super(MessageType.SENSOR_REPORT);
	}

	@Override
	public List<Byte> getBytes() throws MessageParsingException {
		List<Byte> result = getHeaderBytes();
		for(Object value : values.values()){
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
		}
		return result;
	}

}
