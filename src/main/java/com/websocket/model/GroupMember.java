package com.websocket.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class GroupMember extends BaseEntity{
	
	
	
	@ManyToOne	
	GroupTable group;
	
	@ManyToOne	
	AppUser appUser;
	
	@Enumerated(EnumType.STRING)
	Role role;
	@OneToMany(mappedBy="group", cascade=CascadeType.ALL)
	List<Messages> messages = new ArrayList<>();	
	

}
