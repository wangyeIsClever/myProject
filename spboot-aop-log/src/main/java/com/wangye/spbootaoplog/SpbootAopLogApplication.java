package com.wangye.spbootaoplog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangye.spbootaoplog.mapper")
public class SpbootAopLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbootAopLogApplication.class, args);
    }

}
