package com.sun.jsp.utils.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;
import javax.validation.Payload;
/**
 * @自定義驗證
 * @Author:lvxiaoke
 * @Date: 2019/1/9
 * @
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
    //flag的有效值多個使用","隔開
    String values();

    // 提示內容
    String message() default "flag 不存在";

    Class<?>[]groups() default {};

    Class<? extends Payload>[]payload()default {};

}
