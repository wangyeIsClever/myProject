package com.wangye.spbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.HashSet;
import java.util.Set;

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

        Jedis jedis = new Jedis();
        SetParams setParams = new SetParams();
        // 当Key不存在的时候设置值，并且设置这个可以的过期时间
        jedis.set("kwy","value",setParams.ex(10).nx());

        Set<String> strings = new HashSet();
        return true;
    }

    @RequestMapping("/get/{key}")
    public String addToRedis(@PathVariable("key") String key){
        return redisTemplate.opsForValue().get(key);
    }

}
