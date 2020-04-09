package com.jxy.blog.controllers;


import com.jxy.blog.config.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: jxy
 * @create: 2019-05-28 15:59
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private ServiceConfig config;

    @RequestMapping("/info")
    public String getInfo() {
        return config.getExampleProperty();
    }

    @RequestMapping("/m1")
   // @PreAuthorize("hasRole('ADMIN')")
    public UserModel getById() {
        UserModel userModel = new UserModel();
        userModel.setUsername("不认证能访问 9002");
        userModel.setEmail("111@QQ.COM");
        return userModel;
    }

    @RequestMapping("/m2")
    public UserModel getById2() {
        UserModel userModel = new UserModel();
        userModel.setUsername("不认证能访问 9002");
        userModel.setEmail("111@QQ.COM");
        return userModel;
    }
}
