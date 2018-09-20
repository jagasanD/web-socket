package com.websocket.controller;

import com.websocket.bean.GenericResponse;
import com.websocket.bean.MessageBean;
import com.websocket.bean.UserBean;
import com.websocket.model.AppUser;
import com.websocket.model.UserResponse;
import com.websocket.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author root
 */
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String loginForm() {
        System.out.println(" login forms------------------------");
        return "login.html";

    }

    @PostMapping("/login")
    public ResponseEntity<GenericResponse> loginUser(@RequestBody UserBean bean) {
        try {
            System.out.println(" ----------loginUser-----------------------");
            GenericResponse reponse = loginService.validateUser(bean);
            return new ResponseEntity<>(reponse, HttpStatus.OK);
        } catch (Exception e) {

            e.printStackTrace();
            GenericResponse reponse = new GenericResponse("AUNAUTHORIZED USER ", "Invalide authentication ");
            return new ResponseEntity<>(reponse, HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/get-user-list")
    public ResponseEntity<GenericResponse> getUserList() {
        try {
            System.out.println(" ----------user list controller-----------------------");
            GenericResponse reponse = loginService.getUsers();
            return new ResponseEntity<>(reponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            GenericResponse reponse = new GenericResponse("AUNAUTHORIZED USER ", "Something went wrong");
            return new ResponseEntity<>(reponse, HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/chat-app")
    public String chatApp() {
        return "chatPage.html";
    }

    @PostMapping("/get-single-chat-message")
    public ResponseEntity<GenericResponse> getPrivateMessage(@RequestBody MessageBean bean) {
        try {
            System.out.println(" ----------getPrivateMessage controller-----------------------");
            GenericResponse reponse = loginService.getPrivateMessage(bean);
            return new ResponseEntity<>(reponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            GenericResponse reponse = new GenericResponse("AUNAUTHORIZED USER ", "Something went wrong");
            return new ResponseEntity<>(reponse, HttpStatus.CONFLICT);
        }

    }
    
    @PostMapping("/save-message")
      public ResponseEntity<GenericResponse> saveMessage(@RequestBody MessageBean bean) {
        try {
            System.out.println(" ----------save message controller-----------------------");
             template.convertAndSend("/topic/user/"+bean.getReciviedBy(),bean);
            GenericResponse reponse = loginService.saveMessage(bean);
            return new ResponseEntity<>(reponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            GenericResponse reponse = new GenericResponse("AUNAUTHORIZED USER ", "Something went wrong");
            return new ResponseEntity<>(reponse, HttpStatus.CONFLICT);
        }

    }

    @MessageMapping("/user") // getting data from client side(browser)
    // @SendTo("/topic/user")
    public void getUser(AppUser user) {
        template.convertAndSend("/topic/user", new UserResponse("hi ... " + user.getFirstName() + " " + user.getLastName()));
    }

}
