package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallAdmin {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String nickName;

    private String note;

    private Integer lastLogin;

    private Integer signupTime;

    private Boolean status;

    private Boolean isOnline;
}
