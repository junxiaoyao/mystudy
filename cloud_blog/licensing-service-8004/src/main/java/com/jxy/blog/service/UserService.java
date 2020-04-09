package com.jxy.blog.service;

import com.jxy.blog.entity.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient("zuul")
//public interface UserService {
//    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", value = "/api/user-service/test/m1")
//    UserModel getById();
//    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", value = "/api/user-service/test/m2")
//    UserModel getById2();
//}
@FeignClient("user-service")
public interface UserService {
    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", value = "/test/m1")
    UserModel getById();
    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", value = "/test/m2")
    UserModel getById2();
}