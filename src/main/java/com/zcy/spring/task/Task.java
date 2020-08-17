package com.zcy.spring.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//定时任务是懒加载的 如果服务器没有访问DispatchServlet 任务不会执行
public class Task {
    //0 0 12 * * * ?  每天中午12点触发
    //0 15 10 ? * *   每天上午10：15触发
    //@Scheduled(cron = "0/5 * * * * ?")//每五秒执行一次

    @Scheduled(fixedDelay = 1000*10)//每十秒执行一次
    public void task1(){
        System.out.println("task1()任务在执行");
    }
}
