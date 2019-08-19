package com.wangye.candp2.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wangye.dubbo.serInterface.BeyService;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Reference(version = "1.0.0")
    private BeyService beyService;

    public void sayBey(String msg){
        beyService.sayBay(msg);
    }
}
