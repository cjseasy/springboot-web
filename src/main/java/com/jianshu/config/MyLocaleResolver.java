package com.jianshu.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言连接
        String language=request.getParameter("l");
        //如果没有求就使用默认的
        Locale locale=Locale.getDefault();
        //如果请求连接不为空，携带了国际化参数
        if(!StringUtils.isEmpty(language)){
            String[] split=language.split("_");
            //国家，地区
           locale= new Locale(split[0],split[1]);

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
