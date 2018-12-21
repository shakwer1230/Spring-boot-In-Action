package com.sun.jsp.service;

import com.sun.jsp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/20
 * @
 */
//JpaRepository 提供的简单查询接口
// JpaSpecificationExecutor 提供复杂查询接口
public interface UserJPA extends JpaRepository<User,Long> ,JpaSpecificationExecutor<User>,Serializable{

}
