package com.sun.jsp.model;

import com.sun.jsp.utils.validator.FlagValidator;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/9
 * @
 */
@Entity
@Data
public class ValidateEntity implements Serializable {
    @NotBlank
    @Length(min = 2,max = 10)
    @Id
    public String name;

    @Min(value = 1)
    public Integer age;

    @Email
    @NotBlank
    public String mail;

    @FlagValidator(values = "1,2,3")
    public String flag;
}
