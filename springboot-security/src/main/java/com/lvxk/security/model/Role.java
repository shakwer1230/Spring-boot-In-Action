package com.lvxk.security.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/15
 * @
 */
@Table(name = "role")
@Entity
@Data
public class Role implements Serializable{
    @Id
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;
}
