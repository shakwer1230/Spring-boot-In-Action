package com.sun.jsp.utils.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/9
 * @
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Object> {
    //臨時變量保存flag值列表
    private String values;

    @Override
    public void initialize(FlagValidator constraintAnnotation) {
        this.values=constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String[]value_array=values.split(",");
        boolean isFlag=false;
        for (String _value :
                value_array) {
            //存在一致 跳出循環
            if(_value.equals(value)){
                isFlag=true;
                break;
            }
        }
        return isFlag;
    }
}
