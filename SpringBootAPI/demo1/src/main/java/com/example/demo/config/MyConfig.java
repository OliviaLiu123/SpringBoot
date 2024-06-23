package com.example.demo.config;
/*
自定义配置
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class MyConfig {
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    public void printAppConfig() {
        System.out.println("App Name: " + appName);
        System.out.println("App Version: " + appVersion);
    }

    // Getters and Setters
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }




}
