package com.freeLearn.wall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class WallAdmin implements Serializable {
    private Integer id;

    private String username;

    // 加密后的密码
    @ApiModelProperty(value = "加密后的密码")
    private String password;

    private String email;

    private String nickName;

    // 备注信息
    @ApiModelProperty(value = "备注信息")
    private String note;

    private Integer lastLogin;

    private Integer signupTime;

    // 帐号启用状态：0->禁用；1->启用
    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Boolean status;

    // 是否在线
    @ApiModelProperty(value = "是否在线")
    private Boolean isOnline;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        sb.append(", nickName=").append(nickName);
        sb.append(", note=").append(note);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", signupTime=").append(signupTime);
        sb.append(", status=").append(status);
        sb.append(", isOnline=").append(isOnline);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}