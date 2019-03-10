package com.example.spring_security_and_boot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启权限验证
public class TestController {

    @RequestMapping("/")
    public String root(){
        return "hello Spring Security";
    }

    @RequestMapping("/hello")
    public String hello(){
        return  "hello others";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')") //限定只有Admin权限才能访问
    @RequestMapping("/roleAdminCanAccess")
    public String amdin(){
        return "hello admin role user";
    }
}
