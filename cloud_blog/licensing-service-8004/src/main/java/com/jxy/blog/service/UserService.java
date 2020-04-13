package com.jxy.blog.service;

import com.jxy.blog.config.FeignConfig;
import com.jxy.blog.entity.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "zuul",configuration = FeignConfig.class)
public interface UserService {
    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", value = "/api/user-service/test/m1")
    UserModel m1();
    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", value = "/api/user-service/test/m2")
    UserModel m2();
}
//@FeignClient(name = "user-service",configuration = FeignConfig.class)
//public interface UserService {
//    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", value = "/test/m1")
//    UserModel m1();
//    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", value = "/test/m2")
//    UserModel m2();
//}