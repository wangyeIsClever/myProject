package shiroTest;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


public class JdbcRealmTest {

    JdbcRealm jdbcRealm = new JdbcRealm();

    {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/wangye");
        dataSource.setPassword("root");
        dataSource.setUsername("root");
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true); // 一定要设置这个选项，jdbcRealm 才会去查权限数据。
    }

    @Test
    public void test(){
        // 1. 构建shiro环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);
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
