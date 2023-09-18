package com.sender.redis1.controller;

import com.sender.redis1.service.MessageSendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class MessageSendingController {
    @Autowired
    private MessageSendingService messageSender;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        messageSender.sendMessage(message);
        return ResponseEntity.ok("Message sent: " + message);
    }
}
