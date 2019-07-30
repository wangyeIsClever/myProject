package com.wangye.spbootlogback;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangye.spbootlogback.mapper")
public class SpbootLogbackApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpbootLogbackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpbootLogbackApplication.class, args);
        logger.trace("trace 打印了");
        logger.debug("debug 打印了");
        logger.info("info 打印了");
        logger.warn("warn 打印了");
        logger.error("error 打印了");
    }

}
