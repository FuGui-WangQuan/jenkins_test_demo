package com.zcy.spring.controller;

import com.zcy.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/transMoney")
    @ResponseBody
    public String transMoney() {
        accountService.transMoney(1, 2, 500);

        return "ok";
    }

}
