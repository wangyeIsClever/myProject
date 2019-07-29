package com.wangye.spbootjtaautomatic.service;


import com.wangye.spbootjtaautomatic.mapper1.UserMapper1;
import com.wangye.spbootjtaautomatic.mapper2.UserMapper2;
import com.wangye.spbootjtaautomatic.model1.User1;
import com.wangye.spbootjtaautomatic.model2.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
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

    @Transactional
    public String adUserTransaction1(){
        User1 user1 = new User1();
        user1.setName("小八");
        user1.setAge(15);
        userMapper1.addUser(user1);
        int i = 1 / 0;
        return "success";
    }

    @Transactional
    public String adUserTransaction2(){
        User2 user2 = new User2();
        user2.setName("小留");
        user2.setAge(16);
        userMapper2.addUser(user2);
        int i = 1 / 0;
        return "success";
    }

    @Transactional
    public String addUserToTwoDataSource1(){
        User1 user1 = new User1();
        user1.setName("小四");
        user1.setAge(15);
        userMapper1.addUser(user1);
        int i = 1 / 0 ;
        User2 user2 = new User2();
        user2.setName("小屋");
        user2.setAge(16);
        userMapper2.addUser(user2);
        return "success";
    }

    @Transactional
    public String addUserToTwoDataSource2(){
        User2 user2 = new User2();
        user2.setName("小屋");
        user2.setAge(16);
        userMapper2.addUser(user2);
        int i = 1 / 0 ;

        User1 user1 = new User1();
        user1.setName("小四");
        user1.setAge(15);
        userMapper1.addUser(user1);
        return "success";
    }

    @Transactional
    public String addUserToTwoDataSource3(){
        User2 user2 = new User2();
        user2.setName("小屋");
        user2.setAge(16);
        userMapper2.addUser(user2);


        User1 user1 = new User1();
        user1.setName("小四");
        user1.setAge(15);
        userMapper1.addUser(user1);
        int i = 1 / 0 ;
        return "success";
    }

    @Transactional
    public String addUserToTwoDataSource4(){
        User1 user1 = new User1();
        user1.setName("小四");
        user1.setAge(15);
        userMapper1.addUser(user1);

        User2 user2 = new User2();
        user2.setName("小屋");
        user2.setAge(16);
        userMapper2.addUser(user2);
        int i = 1 / 0 ;
        return "success";
    }
}
