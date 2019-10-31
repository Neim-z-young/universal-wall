package com.freeLearn.wall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class WallUser implements Serializable {
    private Integer id;

    // 用户唯一名称
    @ApiModelProperty(value = "用户唯一名称")
    private String username;

    // 加密后的密码
    @ApiModelProperty(value = "加密后的密码")
    private String password;

    private String email;

    // 微信openid
    @ApiModelProperty(value = "微信openid")
    private String openId;

    // 昵称, 可与他人重复
    @ApiModelProperty(value = "昵称, 可与他人重复")
    private String nickName;

    private Integer lastLogin;

    private Integer signupTime;

    // 帐号启用状态：0->禁用；1->启用
    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Boolean status;

    // 是否在线
    @ApiModelProperty(value = "是否在线")
    private Boolean isOnline;

    // 0->未知,1->男,2->女
    @ApiModelProperty(value = "0->未知,1->男,2->女")
    private Integer gender;

    // 成长值
    @ApiModelProperty(value = "成长值")
    private Integer growth;

    // 用户积分
    @ApiModelProperty(value = "用户积分")
    private Integer points;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getSignupTime() {
        return signupTime;
    }

    public void setSignupTime(Integer signupTime) {
        this.signupTime = signupTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", openId=").append(openId);
        sb.append(", nickName=").append(nickName);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", signupTime=").append(signupTime);
        sb.append(", status=").append(status);
        sb.append(", isOnline=").append(isOnline);
        sb.append(", gender=").append(gender);
        sb.append(", growth=").append(growth);
        sb.append(", points=").append(points);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}