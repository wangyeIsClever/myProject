package com.wangye.spbootmybatis1.mapper;

import com.wangye.spbootmybatis1.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserById(@Param("id") Long id);

}
