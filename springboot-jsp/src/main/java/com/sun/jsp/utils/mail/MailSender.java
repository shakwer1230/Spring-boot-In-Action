package com.sun.jsp.utils.mail;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.List;
import java.util.Properties;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/21
 * @
 */
public class MailSender {

    Logger logger= LoggerFactory.getLogger(MailSender.class);
    private Mail mail=new Mail();

    public MailSender title(String title){
        mail.setTitle(title);
        return  this;
    }

    public MailSender content(String content){
        mail.setContent(content);
        return  this;
    }
    public MailSender contentType(MailContentTypeEnum contentTypeEnum){
        mail.setContentType(contentTypeEnum.getValue());
        return this;
    }

    public  MailSender targets(List<String>targets){
        mail.setToMailList(targets);
        return this;
    }

    public void send() throws Exception{
        try {
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
                    String username=properties.getProperty("mail.user");
                    String password=properties.getProperty("mail.password");
                    return new PasswordAuthentication(username,password);
                }
            };
            //使用环境属性和授权信息 建立邮件会话
            Session mailSession=Session.getInstance(properties,authenticator);
            //创建邮件信息
            MimeMessage message=new MimeMessage(mailSession);
            //设置发件人
            String nickName= MimeUtility.encodeText(propertiesLoaderUtils.getValue("mail.from.nickname"));
            InternetAddress from =new InternetAddress(nickName+"<"+properties.getProperty("mail.user")+">");
            message.setFrom(from);

            //设置邮件标题
            message.setSubject(mail.getTitle());
            //html发送邮寄
            if(mail.getContentType().equals(MailContentTypeEnum.HTML.getValue())){
                //设置邮件内容体
                message.setContent(mail.getContent(),mail.getContentType());
            }else if(mail.getContentType().equals(MailContentTypeEnum.TEXT.getValue())){
                //文本发送邮件
                message.setText(mail.getContent());
            }
            //发送邮箱地址
            List<String>targets=mail.getToMailList();
            for(int i=0;i<targets.size();i++){
                try {
                    InternetAddress to=new InternetAddress(targets.get(i));
                    message.setRecipient(Message.RecipientType.TO,to);
                    Transport.send(message);
                }catch (Exception e){
                    continue;

                }

            }
        }catch (Exception e){
            logger.error("发送邮件错误："+e.toString());
        }

    }
}
