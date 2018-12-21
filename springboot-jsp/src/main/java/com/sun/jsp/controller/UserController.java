package com.sun.jsp.controller;

import com.sun.jsp.model.User;
import com.sun.jsp.service.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/20
 * @
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserJPA userJPA;

    //查询
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> list(){
        return userJPA.findAll();
    }

    //添加 更新
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public User save(User user){
        return  userJPA.save(user);
    }
    //删除
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public List<User>delete(Long id){
        userJPA.delete(id);
        return userJPA.findAll();
    }

}
