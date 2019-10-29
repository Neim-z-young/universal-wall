package com.freeLearn.wall.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Setter
@Getter
public class WallAdminParam {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    @Email(message = "邮箱格式不合法")
    private String email;

    private String nickName;

    private String note;
}
