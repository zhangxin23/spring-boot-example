package org.sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Author: zhangxin
 * Date:   15-8-28
 */
@Service
public class RedisService {
    private final Random random = new Random();

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        int timeout = random.nextInt(86400);
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }
}
