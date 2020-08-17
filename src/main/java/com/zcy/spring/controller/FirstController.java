package com.zcy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//访问当前控制器下面的方法都必须加上/FirstController路径
@RequestMapping("/FirstController")
public class FirstController {
    /*
        Handler处理器 根据url接受前端传来的参数完成不同的业务，并返回不同的界面
        相当于servlet中的doGet()和doPost()
        {"firstA","firstB"}  为当前控制器配置两个映射路径
        path和value不能同时使用
     */
    //@RequestMapping(value = {"firstA","firstB"},method = RequestMethod.GET)
    @RequestMapping(path = {"firstC","firstD"},method = RequestMethod.GET)
    public ModelAndView first(){
        //数据和view的封装
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg","hello");
        modelAndView.setViewName("hello");

        return modelAndView;
    }

    @GetMapping("first1")
    public ModelAndView first1(){
        //数据和view的封装
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg","hello");
        modelAndView.setViewName("hello");

        return modelAndView;
    }

    @PostMapping("first2")//需要使用post方法访问才可以
    public ModelAndView first2(){
        //数据和view的封装
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg","hello");
        modelAndView.setViewName("hello");

        return modelAndView;
    }

    @RequestMapping("first3")
    public ModelAndView first3(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletRequest.setAttribute("msg","first3 from HttpServletRequest");

        //数据和view的封装
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("hello");

        return modelAndView;
    }

    @RequestMapping("first4")
    public String first4(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){
        //httpServletRequest.setAttribute("msg","first4 from HttpServletRequest");
        model.addAttribute("msg","first4 from Model");
        //返回值类型常用三种：
        //1.ModelAndView 数据和视图
        //2.返回字符串 就是 视图jsp地址 最终会转变为jsp视图
        //3.void 界面不跳转  不返回任何视图(不常用)
        //数据和view的封装

        return "hello";
    }


    /**
     * 重定向 必须加/
     * @return
     */
    @GetMapping("/redirectTest")
    public String redirectTest(){
        return "redirect:/FirstController/first4";
    }

    /**
     * 转发   转发和重定向都要从根开始
     * @return
     */
    @GetMapping("/forwardTest")
    public String forwardTest(){
        return "forward:/FirstController/first4";
    }

}
