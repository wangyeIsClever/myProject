package com.wangye.spbootmybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangye.spbootmybatisplus.mapper.MyUserInfoMapper;
import com.wangye.spbootmybatisplus.model.MyUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyUserInfoService {

    private MyUserInfoMapper myUserInfoMapper;

    @Autowired
    public void setMyUserInfoMapper(MyUserInfoMapper myUserInfoMapper) {
        this.myUserInfoMapper = myUserInfoMapper;
    }

    public MyUserInfo getById(Long id){
        return myUserInfoMapper.selectById(id);
    }

    /**
     * 分页查询
     */
    public IPage<MyUserInfo> getPage(){
        IPage<MyUserInfo> page = new Page<>();
        page.setCurrent(1);
        page.setSize(5);
        page.orders();
        return myUserInfoMapper.selectPage(page,null);
    }
}
