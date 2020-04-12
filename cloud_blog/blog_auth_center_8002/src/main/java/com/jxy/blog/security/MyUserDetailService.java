package com.jxy.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: jxy
 * @Date: 2019/3/11 9:36
 * @Description:
 */
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetail userDetail = new UserDetail();
        List<GrantedAuthority> list = new ArrayList<>();
        if (username.equals("user")) {
            userDetail.setUsername(username);
            userDetail.setPassword(passwordEncoder.encode("123456"));
            userDetail.setRole(Roles.ADMINROLE);
            list.add(new SimpleGrantedAuthority(Roles.USERROLE));
            userDetail.setAuthorities(list);
        }
        if (username.equals("admin")) {
            userDetail.setUsername(username);
            userDetail.setPassword(passwordEncoder.encode("123456"));
            userDetail.setRole(Roles.ADMINROLE);
            list.add(new SimpleGrantedAuthority(Roles.ADMINROLE));
            userDetail.setAuthorities(list);
        }

        return userDetail;
    }
}
