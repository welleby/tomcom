package org.welleby.tomcom.json433;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageTransformer;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;

public class Rf433MessageTransformer implements MessageTransformer {

	@Override
	public AbstractMessage getMessage(MessageType msgType, Object data) throws MessageTransformerException {
		if(!(data instanceof byte[]))
			throw new MessageTransformerException("Unexpected data");
		
		switch(msgType){
		case ACKNOWLEDGE:
			break;
		case CLIENT_ACTION_REQUEST:
			break;
		case CLIENT_ACTION_RESPONSE:
			break;
		case SENSOR_REPORT:
			break;
		case SENSOR_REPORT_REQUEST:
			break;
		case SERVER_ACTION_REQUEST:
			break;
		case SERVER_ACTION_RESPONSE:
			break;
		case SERVER_INFO_REQUEST:
			break;
		case SERVER_INFO_RESPONSE:
			break;
		default:
			break;
		}
		return null;
	}

}
