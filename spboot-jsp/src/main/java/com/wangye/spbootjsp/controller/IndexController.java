package com.wangye.spbootjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("haha","lalalal");
        return "index";
    }
}
