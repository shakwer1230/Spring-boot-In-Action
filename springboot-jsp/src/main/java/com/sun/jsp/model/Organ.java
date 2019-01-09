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
@Data
@Table(name = "organ")
@Entity
public class Organ  implements Serializable{
    @GeneratedValue
    @Id
    @Column(name = "id")
    public Long id;

    @Column(name = "organ_id")
    public String organId;

    @Column(name = "organ")
    public String organ;

    @Column(name = "desc")
    public String desc;
}
