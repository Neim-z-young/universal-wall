package com.freeLearn.wall.model;

import java.io.Serializable;

public class WallUserStatistic implements Serializable {
    private Integer id;

    private Integer userId;

    // 发帖数
    private Integer postingsNum;

    // 未读消息
    private Integer unreadMessages;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostingsNum() {
        return postingsNum;
    }

    public void setPostingsNum(Integer postingsNum) {
        this.postingsNum = postingsNum;
    }

    public Integer getUnreadMessages() {
        return unreadMessages;
    }

    public void setUnreadMessages(Integer unreadMessages) {
        this.unreadMessages = unreadMessages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", postingsNum=").append(postingsNum);
        sb.append(", unreadMessages=").append(unreadMessages);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}