package com.wangye.spboottransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangye.spboottransaction.mapper")
public class SpbootTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbootTransactionApplication.class, args);
    }

}
