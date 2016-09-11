package org.welleby.tomcom.messages;

public abstract class Header{
	private long userId; //The unique User (not needed for small scale
	private long clientId; //The RF-clientId
	private long componentId; //The Id of the component on the client
	private long sequenceNumber; //The sequence number of the particular message
	protected final MessageType messageType; //The type of message

	public Header(MessageType messageType) {
		this.messageType = messageType;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public long getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getComponentId() {
		return componentId;
	}
	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}
}
