package com.jxy.blog.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ServiceConfig{

  @Value("${example.property}")
  private String exampleProperty;
  @Value("${signing.key}")
  private String jwtSigningKey ;

}
