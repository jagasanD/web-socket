/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websocket.serviceImpl;

import com.websocket.bean.GenericResponse;
import com.websocket.bean.UserBean;
import com.websocket.model.AppUser;
import com.websocket.repository.AppUserRepository;
import com.websocket.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    AppUserRepository appUserRepo;
    
    @Override
    public GenericResponse validateUser(UserBean ubean) {
        
        System.out.println("--------email-----"+ubean.getEmail());
         System.out.println("--------password-----"+ubean.getPassword());
       AppUser user = appUserRepo.findByEmailIgnoreCaseAndPassword(ubean.getEmail(), ubean.getPassword());
       
       UserBean bean = new UserBean();
       
       if(user!=null){
           user.setIsLoggedIn(Boolean.TRUE);
           appUserRepo.save(user);
           bean.setFirstName(user.getFirstName());
           bean.setLastName(user.getLastName());
           bean.setIsLoggedIn(Boolean.TRUE);
           bean.setId(user.getId());
           bean.setEmail(user.getEmail());
           return new GenericResponse(bean, "Successfully Logged in ");
       
       }else{
       
       return new GenericResponse("AUNAUTHORIZED USER ", "Invalide authentication ");
       
       }
        
       
       
    }
    
}
