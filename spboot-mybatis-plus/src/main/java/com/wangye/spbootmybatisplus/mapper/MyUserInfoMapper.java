package com.wangye.spbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.wangye.spbootmybatisplus.model.MyUserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MyUserInfoMapper extends BaseMapper<MyUserInfo> {

    MyUserInfo selectById(@Param("id") Long id);

}
