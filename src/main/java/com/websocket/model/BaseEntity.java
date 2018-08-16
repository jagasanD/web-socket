package com.websocket.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass	
public class BaseEntity {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdDate;
	@Version
	public Timestamp modifyDate;
	
	
	
	
	

}
