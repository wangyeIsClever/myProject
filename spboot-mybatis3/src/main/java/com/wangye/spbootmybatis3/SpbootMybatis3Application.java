package com.wangye.spbootmybatis3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangye.spbootmybatis3.mapper")
public class SpbootMybatis3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpbootMybatis3Application.class, args);
    }

}
