/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websocket.model;

/**
 *
 * @author root
 */
public class UserResponse {
     String content;

    public UserResponse() {

    }

    public UserResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
