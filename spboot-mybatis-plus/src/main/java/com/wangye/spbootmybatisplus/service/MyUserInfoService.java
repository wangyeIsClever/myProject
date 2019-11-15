package com.wangye.spbootmybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangye.spbootmybatisplus.bo.MyUserBO;
import com.wangye.spbootmybatisplus.mapper.MyUserInfoMapper;
import com.wangye.spbootmybatisplus.model.MyUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserInfoService {

    private MyUserInfoMapper myUserInfoMapper;

    @Autowired
    public void setMyUserInfoMapper(MyUserInfoMapper myUserInfoMapper) {
        this.myUserInfoMapper = myUserInfoMapper;
    }

    public MyUserInfo getById(Long id) {
        return myUserInfoMapper.selectById1(id);
    }

    /**
     * 分页查询
     */
    public IPage<MyUserInfo> getPage() {
        IPage<MyUserInfo> page = new Page<>();
        page.setCurrent(1);
        page.setSize(5);
        page.orders();
        return myUserInfoMapper.selectPage(page, null);
    }

    // 自定义分页，下面相当于 select id as id, name as name, age as age from my_user_info WHERE age = 3 LIMIT 0,5
    public IPage<MyUserInfo> getPage1() {
        IPage<MyUserInfo> page = new Page<>(1, 5);
        page.orders();
        MyUserInfo user = new MyUserInfo();
        user.setAge(3);
        return myUserInfoMapper.getPageByUser(page, user);
    }

    // 自定义分页，使用mybatis的分页插件,返回的是自定义的类型
    // 下面相当于 select id as id, name as name from my_user_info WHERE name = 'kiki' LIMIT 0,5
    public IPage<MyUserBO> getPage2() {
        IPage<MyUserBO> page = new Page<>(1, 5);
        page.orders();
        MyUserBO user = new MyUserBO();
        user.setName("kiki");
        return myUserInfoMapper.getPageByUser2(page, user);
    }

    // 调用自带的更新api updateById
    // sql 相当于 UPDATE my_user_info SET name='凯文凯利' WHERE id=5
    public String updateUser() {
        MyUserInfo userInfo = new MyUserInfo();
        userInfo.setId(5L);
        userInfo.setName("凯文凯利");
        int num = myUserInfoMapper.updateById(userInfo);
        if (num > 0) {
            return "success";
        }
        return "false";
    }

    // 使用updateWraper进行更新 下面相当于 UPDATE my_user_info SET name='凯文凯利' WHERE id = 5
    public String updateUser2() {
        MyUserInfo userInfo = new MyUserInfo();
        userInfo.setId(5L);
        userInfo.setName("凯文凯利");
        UpdateWrapper updateWraper = new UpdateWrapper();
        updateWraper.eq("id", 5);
        int num = myUserInfoMapper.update(userInfo, updateWraper);
        if (num > 0) {
            return "success";
        }
        return "false";
    }
    // 使用updateWraper进行更新 UPDATE my_user_info SET name='凯凯',id=7 WHERE id = 5
    public String updateUser3() {
        /*MyUserInfo userInfo = new MyUserInfo();
        userInfo.setId(5L);
        userInfo.setName("凯文凯利");*/
        UpdateWrapper updateWraper = new UpdateWrapper();
        updateWraper.eq("id", 5);
        updateWraper.set("name","凯凯");
        updateWraper.set("id",7);
        int num = myUserInfoMapper.update(null, updateWraper);
        if (num > 0) {
            return "success";
        }
        return "false";
    }

    // 使用selectWraper进行更新 UPDATE my_user_info SET name='凯凯',id=7 WHERE id = 5
    public List<MyUserInfo> selectWraper() {
        QueryWrapper<MyUserInfo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", 7);
        queryWrapper.eq("name","凯凯");
        List<MyUserInfo> myUserInfos = myUserInfoMapper.selectList(queryWrapper);
        return myUserInfos;
    }
}
