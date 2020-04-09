package com.jxy.blog.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

/**
 * @author jxy
 * @className SomeBeanConfig
 * @description 描述
 * @date 2020/4/9 21:11
 */
@Configuration
public class SomeBeanConfig {
    // @Qualifier("oauth2ClientContext")
//    @Bean
//    @Primary
//    public OAuth2RestTemplate restTemplate(OAuth2ProtectedResourceDetails details) {
//        return restTemplate(details);
//    }

//    // @Qualifier("oauth2ClientContext")
//    @Bean
//    @Primary
//    public OAuth2RestTemplate restTemplate(OAuth2ClientContext clientContext,
//                                           OAuth2ProtectedResourceDetails details) {
//        return new OAuth2RestTemplate(details, clientContext);
//    }
}
