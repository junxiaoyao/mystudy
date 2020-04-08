package com.jxy.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserApplication_9001 {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication_9001.class, args);
    }
}
