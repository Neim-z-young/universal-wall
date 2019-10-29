package com.freeLearn.wall.domain;

/**
 * 前端显示的用户信息
 * Create by oyoungy on 2019/10/29
 */
public class WallUserDetailedInformation {

    // 用户唯一名称
    private String username;

    // 昵称, 可与他人重复
    private String nickName;

    // 0->未知,1->男,2->女
    private Integer gender;

    // 成长值
    private Integer growth;

    // 用户积分
    private Integer points;

    private String university;

    private String schoolNumber;

    // 是否实名
    private Boolean isRealNameRegistered;
}
