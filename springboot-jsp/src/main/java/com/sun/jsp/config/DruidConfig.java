package com.sun.jsp.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/20
 * @
 */
@Configuration
public class DruidConfig {
    /**

     * 注册一个StatViewServlet

     * @return

     */
    @Bean
    public ServletRegistrationBean startViewServlet(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //IP白名单
        servletRegistrationBean.addInitParameter("allow",ips());
        //IP黑名单
        //servletRegistrationBean.addInitParameter("deny","10.2.123.193");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername","fang");
        servletRegistrationBean.addInitParameter("loginPassword","fang.com");
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }
    private String ips(){
        StringBuffer stringBuffer = new StringBuffer();
        /**
         搜房出口ip
         */
        stringBuffer.append("119.90.121.65,");
        stringBuffer.append("119.90.121.66");
//        stringBuffer.append("119.90.121.67");
//        stringBuffer.append("106.39.78.2");
//        stringBuffer.append("106.39.78.3");
//        stringBuffer.append("106.39.78.4");
//        stringBuffer.append("119.90.121.2");
//        stringBuffer.append("119.90.121.3");
//        stringBuffer.append("119.90.121.4");
//        stringBuffer.append("60.247.34.10");
//        stringBuffer.append("60.247.34.11");
//        stringBuffer.append("60.247.34.12");
//        stringBuffer.append("106.120.110.202");
//        stringBuffer.append("106.120.110.203");
//        stringBuffer.append("106.120.110.204");
//        stringBuffer.append("10.2.137.190");
        return stringBuffer.toString();
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的格式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
