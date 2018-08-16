package com.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websocket.model.GroupMember;

public interface GroupMemberRespository extends JpaRepository<GroupMember, Long> {

}
