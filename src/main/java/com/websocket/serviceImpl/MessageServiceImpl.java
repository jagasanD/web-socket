package com.websocket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.websocket.bean.MessageBean;
import com.websocket.model.AppUser;
import com.websocket.model.Messages;
import com.websocket.repository.MessageRepository;
import com.websocket.repository.UserRepository;
import com.websocket.service.MessageService;

public class MessageServiceImpl implements MessageService{

	@Autowired
	UserRepository UserRepository;
	@Autowired
	MessageRepository messageRepository;
	
	@Override
	public void saveMessage(MessageBean bean) {
		
		AppUser sendBy = UserRepository.findById(bean.getSendBy()).get();
		AppUser recivedBy = UserRepository.findById(bean.getReciviedBye()).get();
		Messages msg = new Messages();
		//msg.createdDate(new Date());
		msg.setMessage(bean.getMessage());
		msg.setRecivedBy(recivedBy);
		msg.setSendBy(sendBy);
		messageRepository.save(msg);
	
		
	}

}
