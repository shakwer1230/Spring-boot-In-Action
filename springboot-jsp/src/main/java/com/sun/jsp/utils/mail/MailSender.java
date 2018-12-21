package com.sun.jsp.utils.mail;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/21
 * @
 */
public class MailSender {

    private Mail mail=new Mail();

    public MailSender title(String title){
        mail.setTitle(title);
        return  this;
    }

    public MailSender content(String content){
        mail.setContent(content);
        return  this;
    }

    public void send() throws Exception{
        if(mail.getContentType()==null){
            mail.setContentType(MailContentTypeEnum.HTML.getValue());
        }

        if(mail.getTitle()==null||mail.getTitle().length()==0){
            throw  new Exception("郵件標題沒有設置");
        }
        if(mail.getContent()==null||mail.getContent().length()==0){
            throw  new Exception("郵件内容沒有設置");
        }
        if(mail.getToMailList().size()==0){
            throw new Exception("郵件暫無接收人");
        }

        final PropertiesUtil propertiesLoaderUtils=new PropertiesUtil("mail");
        final Properties properties=new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.host",propertiesLoaderUtils.getValue("mail.smtp.service"));
        properties.put("mail.smtp.port",propertiesLoaderUtils.getValue("mail.smtp.port"));

        properties.put("mail.user",propertiesLoaderUtils.getValue("mail.from.address"));
        properties.put("mail.password",propertiesLoaderUtils.getValue("mail.from.smtp.pwd"));

        Authenticator authenticator=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String username=properties.getProperty("username");
                String password=properties.getProperty("password");
                return PasswordAuthentication(username,password);
            }
        };



    }
}
