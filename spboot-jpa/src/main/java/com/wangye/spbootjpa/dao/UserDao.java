package com.wangye.spbootjpa.dao;

import com.wangye.spbootjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Long> {


}
