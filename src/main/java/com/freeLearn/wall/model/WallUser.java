package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallUser {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String openId;

    private Integer lastLogin;

    private Integer signupTime;

    private Boolean status;

    private Boolean isOnline;

    private Integer gender;

    private Integer growth;

    private Integer points;
}
