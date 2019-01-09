package com.sun.jsp.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/21
 * @
 */
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    public static final String DEFAULT_ERROR_VIEW = "error"; // 定义错误显示页，error.html
//    @ExceptionHandler(Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest request,
//                                            Exception e) { // 出现异常之后会跳转到此方法
//        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW); // 设置跳转路径
//        mav.addObject("exception", e); // 将异常对象传递过去
//        mav.addObject("url", request.getRequestURL()); // 获得请求的路径
//        return mav;
//    }
//
//}
