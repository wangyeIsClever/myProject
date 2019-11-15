package com.wangye.spbootmybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wangye.spbootmybatisplus.bo.MyUserBO;
import com.wangye.spbootmybatisplus.model.MyUserInfo;
import com.wangye.spbootmybatisplus.service.MyUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/getPage1")
    public IPage<MyUserInfo> getPage1(){
        return myUserInfoService.getPage1();
    }

    @RequestMapping("/getPage2")
    public IPage<MyUserBO> getPage2(){
        return myUserInfoService.getPage2();
    }

    @RequestMapping("/update")
    public String update(){
        return myUserInfoService.updateUser();
    }

    @RequestMapping("/wraperUpdate")
    public String wraperUpdate(){
        return myUserInfoService.updateUser2();
    }

    @RequestMapping("/wraperUpdate1")
    public String wraperUpdate1(){
        return myUserInfoService.updateUser3();
    }

    @RequestMapping("/selectWraper")
    public List<MyUserInfo> selectWraper(){
        return myUserInfoService.selectWraper();
    }
}
