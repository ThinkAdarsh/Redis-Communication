package com.sender.redis1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSendingService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void sendMessage(String message) {
        stringRedisTemplate.convertAndSend("chat", message);
    }
}
