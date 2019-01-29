package com.lvxk.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/15
 * @
 */
@RestController
public class IndexController
{
    @RequestMapping(value = "/index")
    public String index(){
        return "get index success";
    }
}
