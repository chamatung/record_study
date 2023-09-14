package com.redisbaisc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redisbaisc.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectMapper objectMapper;

    public void setRedisValue(ChatMessage chatMessage) throws JsonProcessingException {
        String key = chatMessage.getSender();
        redisTemplate.opsForValue().set(key, objectMapper.writeValueAsString(chatMessage));
        redisTemplate.expire(key, Duration.ofDays(1));
    }

    public <T> T getRedisValue(String key, Class<T> classType) throws JsonProcessingException {
        String redisValue = (String) redisTemplate.opsForValue().get(key);

        return objectMapper.readValue(redisValue, classType);
    }
}
