package com.chensee.Exception;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class User {

    @NotEmpty(message = "{user.username}")
    private String username;

    @Length(min = 6, max = 16, message = "{user.password.length}")
    @NotEmpty(message = "{user.password}")
    private String password;
}
