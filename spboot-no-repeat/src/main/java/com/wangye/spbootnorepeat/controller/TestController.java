package com.wangye.spbootnorepeat.controller;

import com.wangye.spbootnorepeat.annotation.NoRepeatSubmit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @RequestMapping("/addUser")
    @NoRepeatSubmit
    public String addUser(){
        return "success";
    }
}
