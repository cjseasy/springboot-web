package com.jianshu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//需要模板引擎thymeleaf
public class IndexController {

    @RequestMapping("/index1")
    public String index(){
        return "index";
    }
}
