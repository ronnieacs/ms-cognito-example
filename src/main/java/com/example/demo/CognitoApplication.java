package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;

@SpringBootApplication
@EnableReactiveMethodSecurity
public class CognitoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(CognitoApplication.class, args);
    }
}
