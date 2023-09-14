package com.redisbaisc.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    @Cacheable(value="testCache", key="#key")
    public Map<String, Map> test(String key) {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("key1", "value1");
        testMap.put("key2", "value2");

        Map<String, Map> registCache = new HashMap<>();
        registCache.put("test", testMap);

        System.out.println("테스트");
        return registCache;
    }

}
