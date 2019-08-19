package com.wangye.candp1.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wangye.dubbo.serInterface.HelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference(version = "1.0.0",check = false,interfaceClass = HelloService.class)
    private HelloService helloService;

    @RequestMapping("/hello/{msg}")
    public String hello(@PathVariable String msg){
        helloService.sayHello(msg);
        return "success";
    }

}
