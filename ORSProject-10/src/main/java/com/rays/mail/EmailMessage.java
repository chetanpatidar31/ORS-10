package com.rays.mail;

public class EmailMessage {

	private String to;

	private String subject;

	private String body;

	private int messageType = TEXT_MSG;

	public static final int HTML_MSG = 1;
	public static final int TEXT_MSG = 2;

	public EmailMessage() {
	}

	public EmailMessage(String to, String subject, String body) {
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTo() {
		return to;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public int getMessageType() {
		return messageType;
	}

}
