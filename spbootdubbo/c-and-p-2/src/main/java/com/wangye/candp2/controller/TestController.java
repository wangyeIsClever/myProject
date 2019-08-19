package com.wangye.candp2.controller;

import com.wangye.candp2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private TestService testService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/bay/{msg}")
    public String saybay(@PathVariable String msg){
        testService.sayBey(msg);
        return "success";
    }
}
