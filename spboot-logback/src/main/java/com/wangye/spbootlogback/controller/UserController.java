package com.wangye.spbootlogback.controller;


import com.wangye.spbootlogback.model.User;
import com.wangye.spbootlogback.service.UserService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/getUserById1/{id}")
    @ResponseBody
    public User getUserById1(@PathVariable("id") Long id){
        int i= 1/0;
        return userService.getUserById1(id);
    }

    @RequestMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id){
        User user = null;
        try {
            user =  userService.getUserById(id);
            logger.info("出参:{}",user);
        }catch (Exception e){
            logger.info("异常:{}", ExceptionUtils.getRootCauseMessage(e) + ExceptionUtils.getStackTrace(e));
            logger.info(" 异常路径:{}",e.getStackTrace());
            System.out.println(e.toString());
        }
        return user;
    }
}
