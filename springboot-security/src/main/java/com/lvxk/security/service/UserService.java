package com.lvxk.security.service;

import com.lvxk.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/15
 * @
 */
public class UserService implements UserDetailsService
{

    @Autowired
    UserJPA usejp;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=usejp.findByUsername(username);
        if(user==null){
            throw  new UsernameNotFoundException("未查询到用户:"+username+"的信息！");
        }
        return user;
    }
}
