/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websocket.service;

import com.websocket.bean.GenericResponse;
import com.websocket.bean.UserBean;

/**
 *
 * @author root
 */
public interface LoginService {

    public GenericResponse validateUser(UserBean bean);
    
}
