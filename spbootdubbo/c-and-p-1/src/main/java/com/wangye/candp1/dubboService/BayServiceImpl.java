package com.wangye.candp1.dubboService;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangye.dubbo.serInterface.BeyService;


@Service(version = "1.0.0",interfaceClass = BeyService.class)
public class BayServiceImpl implements BeyService {

    @Override
    public void sayBay(String msg) {
        System.out.println("hello " + msg + "springboot dubbo");
    }
}
