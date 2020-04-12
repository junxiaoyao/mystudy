package com.jxy.blog;

import com.jxy.blog.utils.UserContextInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class UserApplication_9003 {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication_9003.class, args);
    }

    @Bean
    @Primary
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> intercepters = restTemplate.getInterceptors();
        if (intercepters == null) {
            restTemplate.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        } else {
            intercepters.add(new UserContextInterceptor());
            restTemplate.setInterceptors(intercepters);
        }
        return restTemplate;
    }
}
