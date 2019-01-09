package com.sun.jsp.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.jsp.base.BaseEntity;
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
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long id;

    @Column(name = "username")
    public String userName;

//    @JsonIgnore //使用JackJson该字段不被序列化
    @JSONField(serialize = false) // 使用FastJson 该字段不被序列化
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
