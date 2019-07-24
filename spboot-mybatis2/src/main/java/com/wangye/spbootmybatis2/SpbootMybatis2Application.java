package com.wangye.spbootmybatis2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangye.spbootmybatis2.mapper")
public class SpbootMybatis2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpbootMybatis2Application.class, args);
    }

}
