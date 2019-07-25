package com.wangye.spboottransaction.service;


import com.wangye.spboottransaction.mapper.UserMapper;
import com.wangye.spboottransaction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation = Propagation.REQUIRED)
    public String addUser(User user) {
        int updateNum = userMapper.addUser(user);
        int i = 1/0;
        return "插入"+updateNum+"行";
    }
}
