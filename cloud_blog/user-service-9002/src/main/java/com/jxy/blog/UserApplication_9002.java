package com.jxy.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserApplication_9002 {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication_9002.class, args);
    }
}
