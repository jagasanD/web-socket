/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websocket.serviceImpl;

import com.websocket.bean.GenericResponse;
import com.websocket.bean.MessageBean;
import com.websocket.bean.UserBean;
import com.websocket.model.AppUser;
import com.websocket.model.Message;
import com.websocket.repository.AppUserRepository;
import com.websocket.repository.MessageRepository;
import com.websocket.service.LoginService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    @Autowired
    MessageRepository messageRepository;
    
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

    @Override
    public GenericResponse getUsers() {
        List<AppUser> users = appUserRepo.findAll();
        List<UserBean>userList = new ArrayList<>();
        users.forEach((user)->{
        UserBean bean = new UserBean();
        bean.setEmail(user.getEmail());
        bean.setFirstName(user.getFirstName());
        bean.setLastName(user.getLastName());
        bean.setId(user.getId());
        userList.add(bean);
        });
        return new GenericResponse(userList,"Successfully retrive "); 
    }

    @Override
    public GenericResponse getPrivateMessage(MessageBean bean) {
       
        List<Message> messages = messageRepository.findBySendByIdAndRecivedByIdOrSendByIdAndRecivedById(bean.getSendBy(),bean.getReciviedBy(),bean.getReciviedBy(),bean.getSendBy());
        List<MessageBean> msgList = new ArrayList<>();
        messages.forEach((msg)-> {
        MessageBean mbean = new MessageBean();
        mbean.setCreateDate(msg.getCreateDate());
        mbean.setIsSeen(msg.getIsSeen());
        mbean.setMessage(msg.getMessage());
        mbean.setReciviedBy(msg.getRecivedBy().getId());
        mbean.setSendBy(msg.getSendBy().getId());
        mbean.setUpdatedDate(msg.getUpdatedDate());
        msgList.add(mbean);
        });
       return new GenericResponse(msgList,"Successfully");  
    }

    @Override
    public GenericResponse saveMessage(MessageBean bean) {
        
        Message message = new Message();
        message.setCreateDate(new Date());
        message.setUpdatedDate(new Date());
        message.setIsSeen(Boolean.FALSE);
        message.setMessage(bean.getMessage());
        message.setRecivedBy(appUserRepo.getOne(bean.getReciviedBy()));
        message.setSendBy(appUserRepo.getOne(bean.getSendBy()));
        messageRepository.save(message);
        return new GenericResponse("saved Message ","OK");
    }
    
}
