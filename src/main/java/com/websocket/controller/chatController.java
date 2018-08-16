package com.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websocket.bean.MessageBean;
import com.websocket.repository.UserRepository;
import com.websocket.service.MessageService;


@CrossOrigin
@Controller
public class chatController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	MessageService messageService;
	
	
	 @Autowired
	  private SimpMessagingTemplate messagingTemplate;
	
	 @RequestMapping("/")
	  public String index() {
	    return "index";
	  }

	  /**
	   * GET  /notifications  -> show the notifications page.
	   */
	  @RequestMapping("/notifications")
	  public String notifications() {
	    return "notifications";
	  }
	  
	  @MessageMapping("/send/message")
	  public void sendMessage(@RequestBody MessageBean bean ) {
		  messageService.saveMessage(bean);
		  messagingTemplate.convertAndSendToUser(bean.getReciviedBye()+"", "/chat", bean);
		  
	  }
	  

}
