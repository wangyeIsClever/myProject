package com.wangye.spbootmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangye.spbootmybatisplus.mapper")
public class SpbootMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbootMybatisPlusApplication.class, args);
    }

}
