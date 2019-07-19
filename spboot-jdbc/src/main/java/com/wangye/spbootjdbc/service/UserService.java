package com.wangye.spbootjdbc.service;

import com.wangye.spbootjdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserById(Long id){

        User user;
        String sql = "select * from user where id = ?";
        List<User> users = jdbcTemplate.query(sql, new Object[] {id},new BeanPropertyRowMapper<User>(User.class));
        if (users.size() > 0){
            user = users.get(0);
            return user;
        }else {
            return null;
        }
    }
}
