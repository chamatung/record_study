package com.redisbaisc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.redisbaisc.dto.ChatMessage;
import com.redisbaisc.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("api/redisTest")
    public String send(@RequestBody ChatMessage chatMessage) throws JsonProcessingException {
        redisService.setRedisValue(chatMessage);
        String key = chatMessage.getSender();
        ChatMessage responseChatMessage = redisService.getRedisValue(key, ChatMessage.class);

        return responseChatMessage.getContext();
    }

}
