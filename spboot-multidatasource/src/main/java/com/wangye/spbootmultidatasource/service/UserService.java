package com.wangye.spbootmultidatasource.service;

import com.wangye.spbootmultidatasource.mapper1.UserMapper1;
import com.wangye.spbootmultidatasource.mapper2.UserMapper2;
import com.wangye.spbootmultidatasource.model1.User1;
import com.wangye.spbootmultidatasource.model2.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserMapper1 userMapper1;

    @Autowired
    public void setUserMapper1(UserMapper1 userMapper1) {
        this.userMapper1 = userMapper1;
    }

    @Autowired
    public void setUserMapper2(UserMapper2 userMapper2) {
        this.userMapper2 = userMapper2;
    }

    private UserMapper2 userMapper2;

    public String addUser(){
        User1 user1 = new User1();
        user1.setName("小四");
        user1.setAge(15);
        userMapper1.addUser(user1);

        User2 user2 = new User2();
        user2.setName("小屋");
        user2.setAge(16);
        userMapper2.addUser(user2);
        return "success";
    }
}
