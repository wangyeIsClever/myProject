package com.wangye.candp1;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@EnableDubboConfiguration
@DubboComponentScan("com.wangye.candp1.dubboService")
public class CAndP1Application {

    public static void main(String[] args) {
        SpringApplication.run(CAndP1Application.class, args);
    }

}
