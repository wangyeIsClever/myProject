package com.wangye.spboottransaction.controller;



import com.wangye.spboottransaction.model.User;
import com.wangye.spboottransaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(name = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
