package com.jxy.blog.config;

import com.jxy.blog.utils.UserContextInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * @author jxy
 * @className SomeBeanConfig
 * @description 描述
 * @date 2020/4/9 21:11
 */
@Configuration
public class SomeBeanConfig {
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

    //@Qualifier("oauth2ClientContext")
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
