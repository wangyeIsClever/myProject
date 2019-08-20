package com.wangye.dubbo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations= {"classpath:rmi/dubbo-config.xml"})
@SpringBootApplication
public class Dubbo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Dubbo2Application.class, args);
    }

}
