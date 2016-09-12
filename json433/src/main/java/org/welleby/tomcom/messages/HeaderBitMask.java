package org.welleby.tomcom.messages;

import java.util.ArrayList;
import java.util.List;

public enum HeaderBitMask {
	CLIENT_ID(0b11111111, 0, 0),
	MESSAGE_TYPE(0b11111100, 1,2),
	SEQUENCE_NUM(0b00000011, 1,0), 
	COMPONENT_ID(0b11110000, 2,4);
	
	private final byte mask;
	private final int byteNr;
	private final int shift;
	
	HeaderBitMask(int mask, int byteNr, int shift){
		this.mask = (byte)mask;
		this.byteNr = byteNr;
		this.shift = shift;
	}
	public byte getMask() {
		return this.mask;
	}
	public int getByteNr() {
		return this.byteNr;
	}
	public int getShift() {
		return this.shift;
	}

	public static long getValue(List<Byte> bytes, HeaderBitMask mask) throws MessageParsingException {
		if(bytes==null || bytes.size()<mask.getByteNr()+1)
			throw new MessageParsingException("Error while getting clientId from bytes");
		else 
			return bytes.get(mask.getByteNr()) & mask.getMask();
	}
	public static List<Byte> getBytes(long value, HeaderBitMask mask) {
		List<Byte> result = new ArrayList<>();
		result.add((byte) ((value << mask.getShift()) & mask.getMask()));
		return result;
	}
	public static Byte getByte(long value, HeaderBitMask mask) {
		return (byte) ((value << mask.getShift()) & mask.getMask());
	}
}