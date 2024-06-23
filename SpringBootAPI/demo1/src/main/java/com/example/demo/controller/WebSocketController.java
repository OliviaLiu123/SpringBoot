package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")// 客户端发送消息到此地址时，会调用下面的方法
    @SendTo("/topic/greetings")// 将方法的返回值发送到"/topic/greetings"地址
    public String greeting(String message) throws Exception{
        //这里可以添加业务逻辑，比如记录日志，验证消息
        return "hello"+message+"!";


    }


}
