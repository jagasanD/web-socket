package com.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websocket.model.Messages;

public interface MessageRepository extends JpaRepository<Messages, Long>{

}
