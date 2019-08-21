package com.wangye.spbootmybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wangye.spbootmybatisplus.model.MyUserInfo;
import com.wangye.spbootmybatisplus.service.MyUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private MyUserInfoService myUserInfoService;

    @Autowired
    public void setMyUserInfoService(MyUserInfoService myUserInfoService) {
        this.myUserInfoService = myUserInfoService;
    }

    @RequestMapping("getById/{id}")
    public MyUserInfo getById(@PathVariable("id") Long id){
        return myUserInfoService.getById(id);
    }

    @RequestMapping("/getPage")
    public IPage<MyUserInfo> getPage(){
        return myUserInfoService.getPage();
    }
}
