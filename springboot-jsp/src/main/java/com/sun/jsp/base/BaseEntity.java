package com.sun.jsp.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/9
 * @
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * 分頁頁碼 默認為1
     */
    public Integer page=1;

    /**
     * 分頁頁面大小 默認為20
     */
    public Integer size=20;

    /**
     * 排序列名稱 默認為id
     */
    public String sIdx="id";

}
