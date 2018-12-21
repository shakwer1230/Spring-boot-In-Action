package com.sun.jsp.utils.mail;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/21
 * @
 */
public class PropertiesUtil {
    private  final ResourceBundle resource;
    private  final  String fileName;

    public PropertiesUtil(String fileName){
        this.fileName=fileName;
        Locale locale=new Locale("zh","cn");
        this.resource=ResourceBundle.getBundle(this.fileName,locale);
    }

    public String getValue(String key) {
        String message=this.resource.getString(key);
        return message;
    }
}
