package com.zcy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
@Controller
public class DateController {
    @RequestMapping("/getDate")//接受的是一个date,并不是String;前端传递String--->mvc 接受Date 就需要一个DateFormat
    public String getDate(Date date, ModelMap modelMap){
        modelMap.put("msg",date.getTime());
        return "hello";
    }
}
