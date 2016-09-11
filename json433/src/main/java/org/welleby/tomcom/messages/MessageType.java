package org.welleby.tomcom.messages;

public enum MessageType {
	ACKNOWLEDGE (0),
	SENSOR_REPORT_REQUEST (1),
	SENSOR_REPORT (2),
	CLIENT_ACTION_REQUEST (3),
	CLIENT_ACTION_RESPONSE (4),
	SERVER_ACTION_REQUEST (5),
	SERVER_ACTION_RESPONSE (6),
	SERVER_INFO_REQUEST (7),
	SERVER_INFO_RESPONSE (8);
	
	private int tgmNr;
	
	MessageType (int tgmNr){
		this.setTgmNr(tgmNr);
	}

	public int getTgmNr() {
		return tgmNr;
	}

	private void setTgmNr(int tgmNr) {
		this.tgmNr = tgmNr;
	}
}
