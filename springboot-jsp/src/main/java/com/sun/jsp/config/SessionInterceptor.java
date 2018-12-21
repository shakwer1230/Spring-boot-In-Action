package com.sun.jsp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/21
 * @攔截器
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if(request.getRequestURI().equals("/error")){
//            throw new Exception("页面访问路径错误");
//        }
        if(request.getRequestURI().equals("/user/login")||request.getRequestURI().equals("/login_view")){
            return true;
        }
        Object user=request.getSession().getAttribute("_session_user");
        if(user==null){
            response.sendRedirect("/login_view");
            return  false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println(request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(request.getRequestURL());
    }
}
