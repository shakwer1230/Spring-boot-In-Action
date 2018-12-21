package com.sun.jsp.utils.mail;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/21
 * @
 */
@Data
public class Mail {
    /**
     * smtp 服務器
     */
    public String smtpService;

    public String smtpPort;

    public String fromMailAddress;

    public String fromMailSmtpPwd;

    public String title;

    public String content;

    public String contentType;

    public List<String> toMailList=new ArrayList<>();
}
