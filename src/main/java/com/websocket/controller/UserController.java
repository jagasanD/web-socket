/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websocket.controller;

import com.websocket.model.User;
import com.websocket.model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 *
 * @author root
 */
@Controller
public class UserController {
    
    
    @MessageMapping("/user") // getting data from client side(browser)
    @SendTo("/topic/user")
    public UserResponse getUser(User user){
        return new UserResponse("hi ... "+user.getName());
    }
    
}