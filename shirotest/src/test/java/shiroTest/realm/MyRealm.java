package shiroTest.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    //模拟数据库用户的数据
    private Map<String,String> users = new HashMap<String, String>(16);
    {
        users.put("zhangsan","b14881724ec29f182f2813a31bbe5d66");

    }

    //模拟数据库角色的数据
    private Map<String, Set<String>> user_roles = new HashMap<String, Set<String>>(16);
    {
        Set<String> zhangsanRole = new HashSet<String>(2);
        zhangsanRole.add("admin");
        zhangsanRole.add("user");
        user_roles.put("zhangsan",zhangsanRole);

    }

    // 模拟数据库中权限数据
    private Map<String,Set<String>> roles_permissions = new HashMap<String, Set<String>>(16);
    {
        Set<String> adminPermission = new HashSet<String>();
        adminPermission.add("user:delete");
        adminPermission.add("user:selete");

        roles_permissions.put("admin",adminPermission);
    }

    //
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1. 首先获取用户名
        String username = (String)getAvailablePrincipal(principals);
        // 2. 根据用户名获取角色
        Set<String> roles = this.getRolesByUserName(username);
        // 3. 根据角色获取权限
        Set<String> permissions = this.getPermissionsByRoles(roles);
        // 4. 创建授权包装类并把角色传入
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        // 5. 设置权限
        info.setStringPermissions(permissions);
        return info;
    }

    private Set<String> getPermissionsByRoles(Set<String> roles) {
        Set<String> permissions = new HashSet<String>();
        for (String role:roles){
            Set<String> permissionsOfRole = roles_permissions.get(role);
            if (permissionsOfRole != null && permissionsOfRole.size() > 0){
                permissions.addAll(permissionsOfRole);
            }
        }
        return permissions;
    }

    private Set<String> getRolesByUserName(String username) {
        return user_roles.get(username);
    }

    // 用于认证的方法
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1. 获取用户名
        String username = (String)token.getPrincipal();
        // 2. 根据用户名获取数据库的密码
        String password = this.getPasswordByUserName(username);
        if (null == password){
            throw new UnknownAccountException("No account found for user [" + username + "]");
        }
        // 3。构造一个认证对象，数据库用户信息包装
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,password,this.getClass().getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("Mark"));
        return simpleAuthenticationInfo;
    }

    //模拟数据库
    private String getPasswordByUserName(String username) {
        return  users.get(username);
    }

    public static void main(String[] args) {
        Md5Hash  md5Hash = new Md5Hash("888888","Mark");

        System.out.println(md5Hash.toString());
    }
}
