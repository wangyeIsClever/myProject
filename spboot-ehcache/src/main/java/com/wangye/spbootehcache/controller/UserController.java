package com.wangye.spbootehcache.controller;


import com.wangye.spbootehcache.model.User;
import com.wangye.spbootehcache.service.UserService;
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

    @RequestMapping("/saveUser/{name}/{age}")
    @ResponseBody
    public String  getUserById(@PathVariable("name") String name,@PathVariable("age") Integer age){
        return "存入了" + userService.saveUser(name,age) + "条记录";
    }
}
