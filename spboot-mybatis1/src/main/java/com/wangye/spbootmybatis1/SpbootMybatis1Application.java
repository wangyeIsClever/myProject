package com.wangye.spbootmybatis1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangye.spbootmybatis1.mapper")
public class SpbootMybatis1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpbootMybatis1Application.class, args);
    }

}
