package com.wangye.spbootehcache.service;


import com.wangye.spbootehcache.mapper.UserMapper;
import com.wangye.spbootehcache.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserMapper userMapper;

    // Spring推荐在不强制依赖的时候，使用这种方式注入
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById1(Long id) {
        logger.info("UserService 中 getUserById1 入参：{}",id);
        return userMapper.getUserById1(id);
    }

    public User getUserById(Long id) {

        return userMapper.getUserById(id);
    }

    public Integer saveUser(String name,Integer age){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        return userMapper.save(user);
    }
}
