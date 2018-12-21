package com.sun.jsp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/20
 * @
 */
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long id;

    @Column(name = "username")
    public String userName;

    @JsonIgnore
    @Column(name = "password")
    public String passWord;

    @Column(name = "role_id")
    public Integer roleId;

    @Column(name = "organ_id")
    public Integer organId;

    @Column(name = "salt")
    public String salt;

    @Column(name = "is_superuser")
    public Integer isSpuerUser;

    @Column(name = "created")
    public Date created;

    @Column(name = "userno")
    public String userNo;

    @Column(name = "desc")
    public String desc;

    @Column(name = "logname")
    public String logName;
}
