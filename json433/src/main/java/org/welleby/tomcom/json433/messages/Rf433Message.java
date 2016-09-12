package org.welleby.tomcom.json433.messages;

import java.util.List;

public interface Rf433Message {
	public abstract List<Byte> getBytes() throws MessageParsingException;
}
