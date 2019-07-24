package com.wangye.spbootmybatis2.service;

import com.wangye.spbootmybatis2.mapper.UserMapper;
import com.wangye.spbootmybatis2.model.User;
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

    public User getUserById(Long id) {

        return userMapper.getUserById(id);
    }
}
