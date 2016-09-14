package org.welleby.tomcom.transformers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.MessageParsingException;
import org.welleby.tomcom.messages.MessageTransformerException;
import org.welleby.tomcom.messages.MessageType;
import org.welleby.tomcom.messages.SensorReport;

public class SensorReportTransformer extends MessageTransformer {
	public SensorReportTransformer() {
		super(MessageType.SENSOR_REPORT);
	}

	private static Logger logger = LogManager.getLogger(SensorReportTransformer.class);

	@Override
	public AbstractMessage getMessage(MessageType msgType, List<Byte> bytes) throws MessageTransformerException {
		validateBytes(msgType, bytes);
		
		SensorReport sensorReport = new SensorReport();
		sensorReport.setHeader(getHeader(msgType, bytes));
		
		return sensorReport;
	}

	@Override
	public List<Byte> getBytes(AbstractMessage message) throws MessageTransformerException {
		try {
			return message.getBytes();
		} catch (MessageParsingException e) {
			throw new MessageTransformerException("Could not get bytes from message", e);
		}
	}

}
