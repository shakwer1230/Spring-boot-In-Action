package com.lvxk.security.service;

import com.lvxk.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/15
 * @
 */
public interface UserJPA extends JpaRepository<User,Long> {

    @Query(value = "select * from t_user where userName=?",nativeQuery = true)
    User findByUsername(String userName);
}
