package com.wangye.spbootglobalexception.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这个类是专门拦截异常的
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello1")
    public String hello1(){
        int i = 1/0;

        return "success";
    }

}
