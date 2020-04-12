package com.jxy.blog.config;

import lombok.Data;
import lombok.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@Data
public class ServiceConfig {
//    @Value("${signing.key}")
    private String jwtSigningKey = "jxy-test-redis-jwt";
}
