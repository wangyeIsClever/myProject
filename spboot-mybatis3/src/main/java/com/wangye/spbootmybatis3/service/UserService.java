package com.wangye.spbootmybatis3.service;


import com.wangye.spbootmybatis3.mapper.UserMapper;
import com.wangye.spbootmybatis3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserMapper userMapper;

    // Spring推荐在不强制依赖的时候，使用这种方式注入
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById1(Long id) {

        return userMapper.getUserById1(id);
    }

    public User getUserById(Long id) {

        return userMapper.getUserById(id);
    }
}
