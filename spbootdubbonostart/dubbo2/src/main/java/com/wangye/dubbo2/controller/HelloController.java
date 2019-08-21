package com.wangye.dubbo2.controller;

import com.wangye.dubboapi.api.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 这里调用的是dubbo1提供的服务
    @Autowired
    private HelloService helloService;

    @RequestMapping("/sayHello/{name}")
    public String sayBye(@PathVariable String name){
        return helloService.sayHello(name);
    }

}
