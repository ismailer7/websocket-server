package com.websocket.server;

import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageSender {

	private SimpMessagingTemplate  messageSendingOperation;
	
	@PostMapping("/send")
	void sendMessage(@RequestBody Message message) {
		messageSendingOperation.convertAndSend("/topic/install", message);
	}
}
