package com.sun.jsp.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/21
 * @
 */
@Configuration
public class ErrorPageConfig {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer(){
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                ErrorPage errorPage_400 = new ErrorPage(HttpStatus.BAD_REQUEST,"/error-400.html");
                ErrorPage errorPage_404 = new ErrorPage(HttpStatus.NOT_FOUND,"/error-404.html");
                ErrorPage errorPage_500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error-500.html");
                container.addErrorPages(errorPage_400,errorPage_404,errorPage_500);
            }
        };
    }

}
