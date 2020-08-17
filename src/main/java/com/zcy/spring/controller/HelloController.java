package com.zcy.spring.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //数据和view的封装
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg","hello");
        modelAndView.setViewName("/jsp/hello.jsp");

        return modelAndView;
    }
}
