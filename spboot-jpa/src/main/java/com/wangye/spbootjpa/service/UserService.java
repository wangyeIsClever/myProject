package com.wangye.spbootjpa.service;

import com.wangye.spbootjpa.dao.UserDao;
import com.wangye.spbootjpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(Long id){
        return userDao.getOne(id);
    }

}
