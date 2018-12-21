package com.sun.jsp.utils.mail;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/21
 * @
 */
public enum  MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"),
    TEXT("text");

    private String value;
    MailContentTypeEnum(String value){
        this.value=value;
    }

    public String getValue() {
         return  this.value;
    }
}
