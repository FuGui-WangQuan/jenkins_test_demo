package com.zcy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @RequestMapping("/exceptionTest")
    @ResponseBody
    public String exceptionTest(){
        int i = 1/0;

        return "ok";
    }

    //局部异常的处理
    //在当前ExceptionController中发生的异常 凡是Exception或者它的子类都会调用此方法返回结果
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exInfo(Exception e){

        return "局部----Exception exInfo" + e.getMessage();
    }
}
