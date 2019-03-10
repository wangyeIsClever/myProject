package com.example.spring_security_and_boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserService myUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* // 在内存中创建一个admin用户，密码为123456，角色为ADMIN,使用BCrypt方式对密码进行加密
        // Spring5之后必须使用加密，不然登录不会成功
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN");
        // 在内存中创建一个zhangsan用户，密码为123456，角色为ADMIN
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangsan")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN");

        // 在内存中创建一个demo用户，密码为demo，角色为USER
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("demo")
                .password(new BCryptPasswordEncoder().encode("demo")).roles("USER");*/

       auth.userDetailsService(myUserService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //设置项目的主目录是可以允许访问的,其他请求需要被验证，注销和表单登陆可以被允许
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()
                .and()
                .formLogin().permitAll();
        //设置其他的任何请求都要经过验证
        http.csrf().disable();//关闭CSRF认证
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/images/**"); //设置忽略的静态文件
    }

}
