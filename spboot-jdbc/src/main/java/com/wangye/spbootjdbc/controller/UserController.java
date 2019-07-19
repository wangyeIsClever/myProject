package com.wangye.spbootjdbc.controller;

import com.wangye.spbootjdbc.entity.User;
import com.wangye.spbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
}
