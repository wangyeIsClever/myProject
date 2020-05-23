package com.wangye.powerMock.dao;

import com.wangye.powerMock.entity.User;

/**
 * Dao中方法模拟数据库不可用的，实际情况中，单元测试的情况下，是不需要连接数据库的。
 */
public final class UserDao {

    public String queryByName(String username){
        throw new UnsupportedOperationException();
    }

}
