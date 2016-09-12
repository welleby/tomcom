package org.welleby.tomcom.messages;

public abstract class Header{
	private Long userId; //The unique User (not needed for small scale
	private Long clientId; //The RF-clientId
	private Long componentId; //The Id of the component on the client
	private Long sequenceNumber; //The sequence number of the particular message
	private final MessageType messageType; //The type of message

	public Header(MessageType messageType) {
		this.messageType = messageType;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public Long getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Long getComponentId() {
		return componentId;
	}
	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}
	public MessageType getMessageType() {
		return messageType;
	}
}
