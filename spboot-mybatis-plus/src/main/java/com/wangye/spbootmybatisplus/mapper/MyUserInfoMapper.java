package com.wangye.spbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wangye.spbootmybatisplus.bo.MyUserBO;
import com.wangye.spbootmybatisplus.model.MyUserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MyUserInfoMapper extends BaseMapper<MyUserInfo> {

    MyUserInfo selectById1(@Param("id") Long id);

    // 自定义分页，使用mybatis的分页插件
    IPage<MyUserInfo> getPageByUser(IPage page, @Param("user") MyUserInfo user);

    // 自定义分页，使用mybatis的分页插件,返回的是自定义的类型
    IPage<MyUserBO> getPageByUser2(IPage<MyUserBO> page, @Param("user") MyUserBO user);
}
