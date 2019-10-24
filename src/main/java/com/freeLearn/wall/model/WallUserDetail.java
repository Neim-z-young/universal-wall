package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallUserDetail {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private String university;

    private String schoolNumber;

    private Boolean isRealNameRegistered;

    private String idCard;

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
