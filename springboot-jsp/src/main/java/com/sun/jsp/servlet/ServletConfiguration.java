package com.sun.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @
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
