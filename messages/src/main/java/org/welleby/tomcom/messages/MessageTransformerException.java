package org.welleby.tomcom.messages;

public class MessageTransformerException extends Exception {
	public MessageTransformerException(String string) {
		super(string);
	}

	public MessageTransformerException(String string, Exception e) {
		super(string,e);
	}

	public MessageTransformerException(MessageParsingException e) {
		super(e);
	}

	private static final long serialVersionUID = -7642017392247776074L;
	
}
