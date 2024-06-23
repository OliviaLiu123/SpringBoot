package com.example.demo.tasks;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 5000)//每5秒执行一次
    public void reportCurrentTime(){
        System.out.println("当前时间"+new Date());
    }

}
