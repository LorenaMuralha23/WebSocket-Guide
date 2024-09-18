package com.example.guide_websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
/* enables WebSocket message hadling, backed by a message broker*/
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
    
    
    /*Default method to configure message broker*/
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        /*enable a simple memory-based message broker to carry the greeting
        messages back to the client on destinations prefixed with /topic*/
        config.enableSimpleBroker("/topic");
        
        /*designates the /app prefix for messages that are bound for methods
        annotated with @MessageMapping*/
        config.setApplicationDestinationPrefixes("/app");
    }
    
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        //registers the /gs-guide-websocket endpoit for websocket connections
        registry.addEndpoint("/gs-guide-websocket");
    }
    
}
