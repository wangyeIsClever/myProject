package com.wangye.dubbo1.controller;

import com.wangye.dubboapi.api.ByeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByeController {

    @Autowired
    private ByeService byeService;

    @RequestMapping("/sayBye/{name}")
    public String sayBye(@PathVariable String name){
        return byeService.sayBye(name);
    }

}
