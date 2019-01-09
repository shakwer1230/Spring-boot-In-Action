package com.sun.jsp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/9
 * @
 */
@Entity
@Table(name = "role")
@Data
public class Role implements Serializable {
    @GeneratedValue
    @Id
    @Column(name = "id")
    public Long id;

    @Column(name = "role")
    public String role;

    @Column(name = "role_id")
    public String roleId;

    @Column(name = "desc")
    public String desc;
}
