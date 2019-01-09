package com.sun.jsp.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/9
 * @
 */
@NoRepositoryBean //不能作为一个Repository创建代理实现类。
public interface BaseRepository<T,PK extends Serializable>extends JpaRepository<T,PK> {
}
