package com.websocket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class Messages extends BaseEntity{
	
	
	
	
	@Column(columnDefinition="TEXT")
	private String message;
	@ManyToOne
	GroupTable group;
	@ManyToOne
	private AppUser sendBy;
	@ManyToOne
	private AppUser RecivedBy;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public GroupTable getGroup() {
		return group;
	}
	public void setGroup(GroupTable group) {
		this.group = group;
	}
	public AppUser getSendBy() {
		return sendBy;
	}
	public void setSendBy(AppUser sendBy) {
		this.sendBy = sendBy;
	}
	public AppUser getRecivedBy() {
		return RecivedBy;
	}
	public void setRecivedBy(AppUser recivedBy) {
		RecivedBy = recivedBy;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
