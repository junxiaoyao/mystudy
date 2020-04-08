package com.jxy.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class LicenseApplication_8004 {
    public static void main(String[] args) {
        SpringApplication.run(LicenseApplication_8004.class, args);
    }
}
