package com.wangye.dubbo1.dubboService;

import com.wangye.dubboapi.api.HelloService;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
