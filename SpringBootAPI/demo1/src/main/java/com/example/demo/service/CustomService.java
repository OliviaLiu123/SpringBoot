package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CustomService {
 private final String message;

    public CustomService(@Value("${custom.service.message}") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
