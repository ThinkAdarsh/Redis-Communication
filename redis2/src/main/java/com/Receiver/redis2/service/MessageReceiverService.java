package com.Receiver.redis2.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiverService implements MessageListener {

    private final StringRedisTemplate stringRedisTemplate;

    public MessageReceiverService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        // Subscribe to the "chat" channel
        stringRedisTemplate.getConnectionFactory().getConnection().subscribe(this, "chat".getBytes());
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String content = new String(message.getBody());

        System.out.println("Received message from channel: " + channel);
        System.out.println("Message content: " + content);
    }
}
