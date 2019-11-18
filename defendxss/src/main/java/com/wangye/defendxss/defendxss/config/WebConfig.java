package com.wangye.defendxss.defendxss.config;

import com.wangye.defendxss.defendxss.filters.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebConfig implements WebMvcConfigurer {


    /**
     * 注册过滤器 每添加一个过滤器都要添加一个这样的方法
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean xssFilterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new XssFilter());
        frBean.setOrder(1);//多个过滤器时指定过滤器的执行顺序
        frBean.addUrlPatterns("/*");
        System.out.println("filter");
        return frBean;
    }

    /**
     * 注册过滤器 每添加一个过滤器都要添加一个这样的方法
     * @return FilterRegistrationBean
     */
    /*@Bean
    public FilterRegistrationBean xssFilterRegist1() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new XssFilter());
        frBean.setOrder(1);//多个过滤器时指定过滤器的执行顺序
        frBean.addUrlPatterns("/*");
        System.out.println("filter");
        return frBean;
    }*/


}
