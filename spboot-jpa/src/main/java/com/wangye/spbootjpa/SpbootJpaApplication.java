package com.wangye.spbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@SpringBootApplication
@EnableJpaRepositories("com.wangye.spbootjpa.dao") // 这里是扫描Dao接口
@EntityScan("com.wangye.spbootjpa.model")// 这里是扫描实体类

public class SpbootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbootJpaApplication.class, args);
    }

}
