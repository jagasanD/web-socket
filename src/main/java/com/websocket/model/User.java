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
public class User {
    
      private String name;
    
    public User(){
    
    }
     public User(String name){
         this.name=name;
    
    }
    public String getName(){
       return this.name;
    }
    public void setName(String name){
    this.name=name;
    }
}
