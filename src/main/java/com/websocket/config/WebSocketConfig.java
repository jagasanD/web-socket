package com.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker	
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	
	 @Override
	    public void configureMessageBroker(MessageBrokerRegistry config) {
		 System.out.println("-----hi first----------");
	        config.enableSimpleBroker("/topic");
	        config.setApplicationDestinationPrefixes("/app");
	    }

	    @Override
	    public void registerStompEndpoints(StompEndpointRegistry registry) {
	    	 System.out.println("-----hi second----------");
	        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
	    }
	  

}
