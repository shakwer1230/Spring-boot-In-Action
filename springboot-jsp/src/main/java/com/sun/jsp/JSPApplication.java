package com.sun.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/18
 * @
 */
@SpringBootApplication
public class JSPApplication  extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(JSPApplication.class);
    }
    public static void main(String[]args){
        SpringApplication.run(JSPApplication.class,args);
    }
}
