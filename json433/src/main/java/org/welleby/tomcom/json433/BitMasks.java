package org.welleby.tomcom.json433;

public enum BitMasks {
	CLIENT_ID(0b11111111),
	MESSAGE_TYPE(0b11111100),
	SEQUENCE_NUM(0b00000011);
	
	private final byte mask;
	
	BitMasks(int mask){
		this.mask = (byte)mask;
	}
	public byte getMask() {
		return mask;
	}
}
