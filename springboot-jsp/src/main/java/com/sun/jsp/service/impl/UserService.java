package com.sun.jsp.service.impl;

import com.sun.jsp.utils.mail.MailContentTypeEnum;
import com.sun.jsp.utils.mail.MailSender;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/21
 * @
 */
@Service
public class UserService {


    public void sendMail(){

        MailSender sender=new MailSender();
        try {

            sender.title("测试发送springboot邮件").content("简单测试文本内容发送").contentType(MailContentTypeEnum.TEXT)
                    .targets(new ArrayList<String>(){{add("lvxiaoke@fang.com");}})
                                        .send();
           //可以啓用異步發送郵件或隊列
        }catch (Exception e){

        }
    }
}
