package com.sun.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.MultipartConfigElement;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/18
 * @
 */
@SpringBootApplication
@ComponentScan
public class JSPApplication  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(JSPApplication.class);
    }
    public static void main(String[]args){
        SpringApplication.run(JSPApplication.class,args);
    }


    //設置上傳文件大小
    // 1、可以再配置文件中設置
    // 2、也可以java後台配置
//    @Bean
//    public MultipartConfigElement multipartConfigElement()
//    { MultipartConfigFactory factory = new MultipartConfigFactory();
//    //单个文件最大 factory.setMaxFileSize("10MB"); //KB,MB /// 设置总上传数据总大小
//        factory.setMaxRequestSize("10MB");
//        return factory.createMultipartConfig();
//    }
}
