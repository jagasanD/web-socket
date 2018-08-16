package com.websocket.bean;

public class MessageBean {

	private Long sendBy;
	private Long reciviedBye;
	private String message;
	
	
	public Long getSendBy() {
		return sendBy;
	}
	public void setSendBy(Long sendBy) {
		this.sendBy = sendBy;
	}
	public Long getReciviedBye() {
		return reciviedBye;
	}
	public void setReciviedBye(Long reciviedBye) {
		this.reciviedBye = reciviedBye;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
