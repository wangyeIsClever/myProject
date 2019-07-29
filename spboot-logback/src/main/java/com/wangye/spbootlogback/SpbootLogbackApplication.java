package com.wangye.spbootlogback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangye.spbootlogback.mapper")
public class SpbootLogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbootLogbackApplication.class, args);
    }

}
