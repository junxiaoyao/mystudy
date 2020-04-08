package com.jxy.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author jxy
 * @className EurekaApplication
 * @description 描述
 * @date 2020/4/7 20:27
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication_7001.class, args);
    }
}
