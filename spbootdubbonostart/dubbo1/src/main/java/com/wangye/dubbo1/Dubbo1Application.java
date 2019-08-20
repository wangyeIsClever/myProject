package com.wangye.dubbo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations= {"classpath:rmi/dubbo-config.xml"})
@SpringBootApplication
public class Dubbo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Dubbo1Application.class, args);
    }

}
