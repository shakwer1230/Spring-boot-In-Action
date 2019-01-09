package com.sun.jsp.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @  Servlet注册
 *  spring 注册servlet两种方法：
 *  1.使用ServletRegistrationBean方法注册
 *  2.使用ServletComponentScan注解扫描
 * @Author:lvxiaoke
 * @Date: 2019/1/8
 * @
 */
@Configuration
public class ServletConfiguration  {
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return  new ServletRegistrationBean(new TestServlet(),"/test");
    }
}
