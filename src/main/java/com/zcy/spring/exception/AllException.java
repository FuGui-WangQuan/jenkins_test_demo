package com.zcy.spring.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
//设置为全局异常
//@ControllerAdvice
public class AllException {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String AllExInfo(Exception e){

        return "全局----Exception AllExInfo" + e.getMessage();
    }
}
