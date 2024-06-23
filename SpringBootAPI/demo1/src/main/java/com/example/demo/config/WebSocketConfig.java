package com.example.demo.config;


/*
创建WebSocket 的配置类
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer{
    //注册一个STOMP协议的endpoint ,并指定使用socket


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 配置消息代理
        registry.enableSimpleBroker("/topic"); // 设置一个前缀为"/topic"的消息代理
        registry.setApplicationDestinationPrefixes("/app"); // 设置客户端发送消息的前缀为"/app"
    }
}
