package com.jxy.blog.controllers;


import com.jxy.blog.config.ServiceConfig;
import com.jxy.blog.entity.UserModel;
import com.jxy.blog.service.UserService;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private UserService userService;

    @RequestMapping("/info")
    public String getInfo() {
        return config.getExampleProperty();
    }

    @RequestMapping("/m1")
    @Hystrix
    @PreAuthorize("hasRole('ADMIN')")
    public Emp getById() {
        Emp emp = new Emp();
        UserModel userModel = userService.m1();
        emp.setName(userModel.getUsername());
        emp.setId(265156L);
        emp.setSex("licence-8005");
        return emp;
    }

    @RequestMapping("/m2")
    public Emp getById2() {
        Emp emp = new Emp();
        UserModel userModel = userService.m2();
        emp.setName(userModel.getUsername());
        emp.setId(265156L);
        emp.setSex("licence-8005");
        return emp;
    }
}
