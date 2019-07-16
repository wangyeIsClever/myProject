package com.wangye.spbootfreemaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("name","王爷");
        return "index";
    }

    /**
     * 转发到/index request中的参数能在下一个请求（目标请求）当中使用
     * 转发返回的http状态码是200，而且url不变
     * @return ModelAndView
     */
    @RequestMapping("/")
    public Object toIndex(){
        ModelAndView mv = new ModelAndView();
        //手动显式指定使用转发，此时springmvc.xml配置文件中的视图解析器将会失效
        mv.setViewName("forward:/index");
        return mv;
    }

    /**
     * 重定向到/index 转发会丢失请求，request里的数据不能再重定向的请求(目标请求)中使用
     * 重定向返回的http状态码是302，而且url会变
     * @return ModelAndView
     */
    @RequestMapping("/toIndex1")
    public Object toIndex1(){
        ModelAndView mv = new ModelAndView();
        //手动显式指定使用转发，此时springmvc.xml配置文件中的视图解析器将会失效
        mv.setViewName("redirect:/index");
        return mv;
    }
}
