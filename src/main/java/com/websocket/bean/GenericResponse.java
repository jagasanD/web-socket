/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websocket.bean;

/**
 *
 * @author root
 */
public class GenericResponse {

    public Object payLoad;

    public String status;

    public String errorMsg;

    public GenericResponse() {
    }

    public GenericResponse(Object payLoad, String status) {

        this.payLoad = payLoad;
        this.status = status;
    }

    public GenericResponse(String errorMsg, String status) {

        this.errorMsg = errorMsg;
        this.status = status;
    }

}
