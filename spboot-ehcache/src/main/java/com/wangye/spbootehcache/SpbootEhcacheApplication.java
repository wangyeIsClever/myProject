package com.wangye.spbootehcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.wangye.spbootehcache.mapper")
@EnableCaching
public class SpbootEhcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbootEhcacheApplication.class, args);
    }

}
