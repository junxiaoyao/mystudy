package com.jxy.blog.config;//package com.jxy.blog.config;
//
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//
//
//@EnableOAuth2Client
//@EnableConfigurationProperties
//@Configuration
//public class OAuth2ClientConfig {
//
////    @Bean
////    @ConfigurationProperties(prefix = "security.oauth2.client")
////    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
////        return new ClientCredentialsResourceDetails();
////    }
//
////    @Bean
////    public OAuth2FeignRequestInterceptor oauth2FeignRequestInterceptor() {
////        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails());
////    }
//
////    @Bean
////    public OAuth2RestTemplate clientCredentialsRestTemplate() {
////        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
////    }
//}
