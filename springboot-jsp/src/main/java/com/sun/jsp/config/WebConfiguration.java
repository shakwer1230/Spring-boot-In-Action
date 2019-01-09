package com.sun.jsp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/21
 * @
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");//验证拦截器
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");//请求日志拦截器

    }

    /**
     * 自定义静态资源路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/springboot/resources/**").addResourceLocations("classpath:/static/");
    }
}
