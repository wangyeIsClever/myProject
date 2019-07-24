package com.wangye.spbootjpa.controller;

import com.wangye.spbootjpa.model.User;
import com.wangye.spbootjpa.service.UserService;
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

        @RequestMapping("/getUserById/{id}")
        public User getUserById(@PathVariable("id") Long id){
            return userService.getUserById(id);
        }
}
