/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websocket.config;


import com.websocket.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author root
 */
@Configuration
@EnableScheduling
public class SchedulerConfig {
    
    @Autowired
    SimpMessagingTemplate template;
    
    @Scheduled(fixedDelay = 3000)
    public void schedule(){
    
        template.convertAndSend("/topic/user", new UserResponse(" fixed delay scheduler "));
    
    }
    
}
