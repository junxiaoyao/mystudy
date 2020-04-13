package com.jxy.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author jxy
 * @className JWTTokenStoreConfig
 * @description 描述
 * @date 2020/4/11 3:23
 */
@Configuration
public class JWTTokenStoreConfig {
    @Autowired
    private ServiceConfig config;


    @Bean
    @Primary
    //用于从令牌中读取数据
    public DefaultTokenServices tokenServices(){
        DefaultTokenServices services=new DefaultTokenServices();
        services.setTokenStore(tokenStore());
        services.setSupportRefreshToken(true);
        return services;
    }

    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter=new JwtAccessTokenConverter();
        converter.setSigningKey(config.getJwtSigningKey());
        return converter;
    }
}
