package com.wangye.powerMock.service;

import com.wangye.powerMock.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class) // 和某某类一起运行
@PrepareForTest({UserService.class,UserDao.class}) // 告诉测试，我要改变这个UserService的字节码
public class UserServiceTest {

    @Test
    public void queryByName() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
        String username = "wangye";
        PowerMockito.doReturn("Geroge").when(userDao).queryByName(username);
        UserService userService = new UserService();
        String result = userService.queryByName(username);
        Assert.assertEquals(result,"Geroge");
    }

    public static class MyArgumentMathcher extends ArgumentMatcher<String>{

        public boolean matches(Object o) {
            String name = (String)o;
            return false;
        }
    }
}