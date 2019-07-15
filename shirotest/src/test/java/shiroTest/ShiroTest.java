package shiroTest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;


public class ShiroTest {

    IniRealm iniRealm = new IniRealm("classpath:user.ini");


    @Test
    public void test(){
        // 1. 构建shiro环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);// 设置环境
        // 主题提交请求认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","888888");
        subject.login(token);// 登录操作
        subject.checkRole("admin");// 检查用户是否有这种权限，无返回值
        System.out.println(subject.hasRole("admin")); // 判断用户是否含有这种权限 ，有返回值
        System.out.println(subject.isPermitted("user:delete"));// 判断用户是否有某权限

    }


}
