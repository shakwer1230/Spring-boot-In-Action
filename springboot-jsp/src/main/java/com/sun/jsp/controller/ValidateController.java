package com.sun.jsp.controller;

import com.sun.jsp.model.ValidateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/9
 * @
 */

@RestController
public class ValidateController {

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/validate")
    public String validator(@Valid ValidateEntity entity, BindingResult result){
        if (result.hasErrors()){
            StringBuffer msg=new StringBuffer();
            List<FieldError> fieldErrors=result.getFieldErrors();
            Locale currentLocal= LocaleContextHolder.getLocale();

            for (FieldError fieldError:fieldErrors){
                String errorMessage=messageSource.getMessage(fieldError,currentLocal);
                msg.append(fieldError.getField()+" ："+errorMessage);
            }
            return  msg.toString();

        }
        return "驗證通過";
    }

}
