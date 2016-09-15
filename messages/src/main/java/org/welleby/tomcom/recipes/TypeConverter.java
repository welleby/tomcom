package org.welleby.tomcom.recipes;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Used to convert JsonText to java types using reflection
 *
 */
public enum TypeConverter {
	BIT,
	NIBBLE,
	BYTE,
	SHORT,
	INT,
	LONG,
	STRING;
	
	private static Map<String,TypeConverter> typeMap = new HashMap<>();
	
	static {
		for(TypeConverter type : TypeConverter.values()) {
			typeMap.put(type.getValue(), type);
		}
	}
	
	@JsonCreator
	public static TypeConverter getType(String str) {
	    return typeMap.get(str);
	}
	
	@JsonValue
	public String getValue() {
		return this.toString();
	}
	
}