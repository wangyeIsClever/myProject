package com.wangye.spbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {


    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @RequestMapping("/add/{key}/{value}")
    public boolean addToRedis(@PathVariable("key") String key,@PathVariable("value") String value){
        redisTemplate.opsForValue().set(key,value);
        return true;
    }

    @RequestMapping("/get/{key}")
    public String addToRedis(@PathVariable("key") String key){
        return redisTemplate.opsForValue().get(key);
    }
}
