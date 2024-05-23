package com.example.myapp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
	
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	System.out.println(session);
    	System.out.println(message);
    	System.out.println("messege recieved");
        String payload = message.getPayload();
        Map< String, String> response = new HashMap<>();
        session.sendMessage(new TextMessage(  payload));
   }
}