package com.sun.jsp.service.impl;

import com.sun.jsp.model.User;
import com.sun.jsp.service.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/15
 * @
 */
@Service
@CacheConfig(cacheNames="user")
//@CacheConfig：该注解是用来开启声明的类参与缓存,
// 如果方法内的@Cacheable注解没有添加key值，那么会自动使用cahceNames配置参数并且追加方法名。
public class UserServiceCache {
    @Autowired
    private UserJPA userJPA;

    //@Cacheable：配置方法的缓存参数，可自定义缓存的key以及value。
    @Cacheable(cacheNames = "alluser")
    public List<User>list(){
        return  userJPA.findAll();
    }

}
