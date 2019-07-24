package com.wangye.spbootmybatis3.controller;


import com.wangye.spbootmybatis3.model.User;
import com.wangye.spbootmybatis3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/getUserById1/{id}")
    public User getUserById1(@PathVariable("id") Long id){
        return userService.getUserById1(id);
    }

    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
}
