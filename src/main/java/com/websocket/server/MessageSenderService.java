package com.websocket.server;


import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@EnableScheduling
public class MessageSenderService {

    private SimpMessagingTemplate messageSendingOperation;

    @Scheduled(cron = "* * * * * *")
    public void scheduledTask() {
        messageSendingOperation.convertAndSend("/topic/install", "some message");
    }
}
