package com.example.demo.config;
/*
自动配置；自动配置的核心机制是条件注解 和 Spring 的组件扫描
Spring Boot在启动时，会扫描项目中的类路径、jar包等位置上的组件，并根据条件注解来决定是否创建和配置相应的Bean
 */
import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix="custom")
public class CustomProperties {
    private String message;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
