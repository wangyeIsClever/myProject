package com.wangye.spbootmultidatasource.controller;

import com.wangye.spbootmultidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/addUser")
    public String addUser(){
        return userService.addUser();
    }

    @RequestMapping("/addUser1")
    public String addUser1(){
        return userService.adUserTransaction1();
    }

    @RequestMapping("/addUser2")
    public String addUser2(){
        return userService.adUserTransaction2();
    }

    @RequestMapping("/addUser3")
    public String addUser3(){
        return userService.addUserToTwoDataSource1();
    }

    @RequestMapping("/addUser4")
    public String addUser4(){
        return userService.addUserToTwoDataSource2();
    }

    @RequestMapping("/addUser5")
    public String addUser5(){
        return userService.addUserToTwoDataSource3();
    }

    @RequestMapping("/addUser6")
    public String addUser6(){
        return userService.addUserToTwoDataSource4();
    }
}
