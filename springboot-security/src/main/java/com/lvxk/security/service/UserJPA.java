package com.lvxk.security.service;

import com.lvxk.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/15
 * @
 */
public interface UserJPA extends JpaRepository<User,Long> {

    User findByUsername(String userName);
}
