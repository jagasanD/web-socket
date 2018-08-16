package com.websocket.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity	
public class GroupTable extends BaseEntity{
	
	private String groupName;
	@OneToMany(mappedBy="group", cascade=CascadeType.ALL)
	private List<GroupMember> groupMembers = new ArrayList<>();
	

}
