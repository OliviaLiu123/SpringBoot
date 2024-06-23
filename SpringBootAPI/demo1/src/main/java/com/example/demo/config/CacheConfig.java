package com.example.demo.config;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;


import java.util.concurrent.TimeUnit;
// 设置缓存

@Configuration
@EnableCaching
public class CacheConfig {
// 这里可以定义缓存管理器、缓存名称等高级配置
@Bean
public CacheManager cacheManager() {
    Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES) // 设置缓存过期时间
            .maximumSize(100); // 设置缓存最大容量

    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setCaffeine(caffeine);
    return cacheManager;
}


}
