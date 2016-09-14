package org.welleby.tomcom.parsers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

import org.welleby.tomcom.messages.AbstractMessage;
import org.welleby.tomcom.messages.Acknowledge;
import org.welleby.tomcom.messages.MessageType;
import org.welleby.tomcom.messages.SensorReport;
import org.welleby.tomcom.transformers.AcknowledgeTransformer;

public class ParserTest {
	private AcknowledgeTransformer ackTrans = new AcknowledgeTransformer();
	
	@Test
	public void acknowledgeBytes2Msg_test() throws Exception {
		List<Byte> bytes = new ArrayList<>();
		bytes.add((byte) 10); //ClientId
		bytes.add((byte) (0 | 1)); //TgmType, SequenceNbr
		bytes.add((byte) (4 << 4)); //ComponentId
		AbstractMessage message = ackTrans.getMessage(MessageType.ACKNOWLEDGE, bytes);
		assertTrue(message instanceof Acknowledge);
		assertEquals(10, message.getClientId().byteValue());
		assertEquals(4, message.getComponentId().byteValue());
		assertEquals(1, message.getSequenceNumber().byteValue());
		assertEquals(bytes, message.getBytes());
	}
	
	@Test
	public void acknowledgeMsg2Bytes_Test() throws Exception {
		Acknowledge ack = new Acknowledge();
		ack.setClientId(10);
		ack.setComponentId(4);
		ack.setSequenceNumber(1);
		List<Byte> bytes = ackTrans.getBytes(ack);
		List<Byte> expected = new ArrayList<>();
		expected.add((byte) 10); //ClientId
		expected.add((byte) (0 | 1)); //TgmType, SequenceNbr
		expected.add((byte) (4 << 4)); //ComponentId
		assertEquals(expected, bytes);
	}
	@Test
	public void sensorReportBytes2Msg_test() throws Exception {
		List<Byte> bytes = new ArrayList<>();
		bytes.add((byte) 10); //ClientId
		bytes.add((byte) ((byte) (MessageType.SENSOR_REPORT.getTgmNr() ) | 1)); //TgmType, SequenceNbr
		bytes.add((byte) (4 << 4)); //ComponentId
		
		AbstractMessage message = ackTrans.getMessage(MessageType.SENSOR_REPORT, bytes);
		assertTrue(message instanceof SensorReport);
		assertEquals(10, message.getClientId().byteValue());
		assertEquals(4, message.getComponentId().byteValue());
		assertEquals(1, message.getSequenceNumber().byteValue());
		
		
		assertEquals(bytes, message.getBytes());
	}
	
	@Test
	public void sensorReportMsg2Bytes_Test() throws Exception {
		Acknowledge ack = new Acknowledge();
		ack.setClientId(10);
		ack.setComponentId(4);
		ack.setSequenceNumber(1);
		List<Byte> bytes = ackTrans.getBytes(ack);
		List<Byte> expected = new ArrayList<>();
		expected.add((byte) 10); //ClientId
		expected.add((byte) (0 | 1)); //TgmType, SequenceNbr
		expected.add((byte) (4 << 4)); //ComponentId
		assertEquals(expected, bytes);
	}
}
