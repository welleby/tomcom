package org.welleby.tomcom.messages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorReport extends RecipeMessage{

	private Map<String,Object> values = new HashMap<>();
	
	public SensorReport() {
		super(MessageType.SENSOR_REPORT);
	}

	@Override
	public List<Byte> getBytes() throws MessageParsingException {
		List<Byte> result = super.getBytes();
		for(Object value : values.values()){
			result.addAll(toBytes(value));
		}
		return result;
	}

}
