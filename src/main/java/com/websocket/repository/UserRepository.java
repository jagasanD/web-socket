package com.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websocket.model.AppUser;

public interface UserRepository  extends JpaRepository<AppUser, Long>{

}
