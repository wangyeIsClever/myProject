package com.wangye.spbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangye.spbootmybatisplus.model.MyUserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MyUserInfoMapper extends BaseMapper<MyUserInfo> {

    MyUserInfo selectById1(@Param("id") Long id);

    IPage<MyUserInfo> getPageByUser(Page page);

}
