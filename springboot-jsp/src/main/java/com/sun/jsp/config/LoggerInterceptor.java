package com.sun.jsp.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.jsp.model.LoggerEntity;
import com.sun.jsp.utils.HttpUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @日志拦截器
 * @Author:lvxiaoke
 * @Date: 2018/12/25
 * @
 */
public class LoggerInterceptor implements HandlerInterceptor {
    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoggerEntity logger=new LoggerEntity();
        String sessionId=request.getRequestedSessionId();
        String uri=request.getRequestURI();
        String paramData= JSON.toJSONString(request.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue);


        logger.setClientIp(HttpUtils.getCliectIp(request));
        logger.setMethod(request.getMethod());
        logger.setType(HttpUtils.getRequestType(request));

        logger.setParamData(paramData);
        logger.setUri(uri);
        logger.setSessionId(sessionId);

        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        request.setAttribute(LOGGER_ENTITY,logger);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
