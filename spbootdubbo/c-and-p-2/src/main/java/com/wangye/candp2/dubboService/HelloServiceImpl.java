package com.wangye.candp2.dubboService;


import com.alibaba.dubbo.config.annotation.Service;
import com.wangye.dubbo.serInterface.HelloService;

@Service(version = "1.0.0",interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService {


    @Override
    public void sayHello(String msg) {
        System.out.println("hello " + msg + " Springboot hello");
    }
}
