package com.wangye.spbootaoplog.controller;


import com.wangye.spbootaoplog.model.User;
import com.wangye.spbootaoplog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/getUserById1/{id}")
    @ResponseBody
    public User getUserById1(@PathVariable("id") Long id){
        return userService.getUserById1(id);
    }

    @RequestMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
}
