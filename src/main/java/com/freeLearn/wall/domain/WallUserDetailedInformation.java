package com.freeLearn.wall.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 前端显示的用户信息
 * Create by oyoungy on 2019/10/29
 */
@Getter
@Setter
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

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", nickName=").append(nickName);
        sb.append(", gender=").append(gender);
        sb.append(", growth=").append(growth);
        sb.append(", points=").append(points);
        sb.append(", university=").append(university);
        sb.append(", schoolNumber=").append(schoolNumber);
        sb.append(", isRealNameRegistered=").append(isRealNameRegistered);
        sb.append("], serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
