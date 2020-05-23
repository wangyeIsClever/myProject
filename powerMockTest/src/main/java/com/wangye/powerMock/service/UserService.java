package com.wangye.powerMock.service;

import com.wangye.powerMock.dao.UserDao;

import javax.naming.Name;

public class UserService {

    public String queryByName(String username){
        UserDao userDao = new UserDao();
        return userDao.queryByName(username);
    }

}
