package com.sun.jsp.service;

import com.sun.jsp.model.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @日志请求
 * @Author:lvxiaoke
 * @Date: 2018/12/25
 * @
 */
public interface LoggerJPA extends JpaRepository<LoggerEntity,Long> {
}
