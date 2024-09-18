package com.example.guide_websocket.controller;

import com.example.guide_websocket.entities.Greeting;
import com.example.guide_websocket.entities.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    /*
        * Ensures that, if a message is sent to the /hello destination,
        * the greeting method is called
    */
    @MessageMapping("/hello")
    
    /*
        * Ensures that the return value is broadcast to all 
        * subscribers of "/topic/greetings"
    */
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        Thread.sleep(1000);
        return new Greeting("Hello, "
                + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
