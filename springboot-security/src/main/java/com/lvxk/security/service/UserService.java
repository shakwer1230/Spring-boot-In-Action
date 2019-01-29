package com.lvxk.security.service;

import com.lvxk.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/15
 * @
 */
public class UserService implements UserDetailsService
{

    @Autowired
    UserJPA userJPA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userJPA.findByUsername(username);
        if(user==null){
            throw  new UsernameNotFoundException("未查询到用户:"+username+"的信息！");
        }
        return user;
    }
}
