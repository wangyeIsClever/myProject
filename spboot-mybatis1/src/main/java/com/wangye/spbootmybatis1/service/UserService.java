package com.wangye.spbootmybatis1.service;

import com.wangye.spbootmybatis1.mapper.UserMapper;
import com.wangye.spbootmybatis1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById(Long id) {

        return userMapper.getUserById(id);
    }
}
