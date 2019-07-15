package shiroTest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import shiroTest.realm.MyRealm;

public class MyRealmTest {

    shiroTest.realm.MyRealm myRealm = new MyRealm();

    {
        // 创建一个密码适配
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5"); // 设置加密算法
        matcher.setHashIterations(1);// 设置加密次数
        myRealm.setCredentialsMatcher(matcher); // 把加密适配设置到realm自定义的Realm
    }
    @Test
    public void test(){
        // 1. 构建shiro环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);// 设置环境
        // 主题提交请求认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","888888");
        subject.login(token);// 登录操作
        System.out.println("登录成功");
        subject.checkRole("admin");// 检查用户是否有这种权限，无返回值
        System.out.println(subject.hasRole("admin")); // 判断用户是否含有这种权限 ，有返回值
        System.out.println(subject.isPermitted("user:delete"));// 判断用户是否有某权限

    }
}
