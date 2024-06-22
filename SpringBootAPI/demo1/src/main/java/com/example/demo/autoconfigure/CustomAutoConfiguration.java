package com.example.demo.autoconfigure;
import com.example.demo.config.CustomProperties;
import com.example.demo.service.CustomService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CustomProperties.class)
@ConditionalOnProperty(name = "custom.enabled", havingValue = "true", matchIfMissing = false)
public class CustomAutoConfiguration {

    @Bean
    public CustomService customService(CustomProperties customProperties){
        return new CustomService(customProperties.getMessage());
    }

}


