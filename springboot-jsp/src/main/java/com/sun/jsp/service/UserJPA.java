package com.sun.jsp.service;

import com.sun.jsp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/20
 * @
 */
//JpaRepository 提供的简单查询接口
// JpaSpecificationExecutor 提供复杂查询接口
    @Transactional //@Transactional，来开启事务自动化管理 增刪改查需開啟
public interface UserJPA extends JpaRepository<User,Long> ,JpaSpecificationExecutor<User>,Serializable{

    //nativeQuery = true 表明使用了原生的sql,默認false
    @Query(value = "select * from user where organ_id = ?",nativeQuery = true)
    public List<User>findUserByOrOrganLevel(int organ);

    //@Modifying注解一共使用，则可以完成数据的删除、添加、更新操作
    @Modifying
    @Query(value = "delete FROM  user where username=? and logname=?",nativeQuery = true)
    public void deleteQuery(String name,String pwd);
}
