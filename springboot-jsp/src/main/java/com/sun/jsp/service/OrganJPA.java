package com.sun.jsp.service;

import com.sun.jsp.model.Organ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/9
 * @//QueryDslPredicateExecutor提供的querydsl查询接口
 */
public interface OrganJPA extends JpaRepository<Organ,Long>,QueryDslPredicateExecutor<Organ> {
}
