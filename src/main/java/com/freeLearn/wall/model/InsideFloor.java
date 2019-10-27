package com.freeLearn.wall.model;

import java.io.Serializable;

public class InsideFloor implements Serializable {
    private Integer id;

    // 楼层id
    private Integer floorsId;

    private Integer replyTime;

    private String comment;

    private Integer userId;

    private Boolean isRead;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFloorsId() {
        return floorsId;
    }

    public void setFloorsId(Integer floorsId) {
        this.floorsId = floorsId;
    }

    public Integer getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Integer replyTime) {
        this.replyTime = replyTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", floorsId=").append(floorsId);
        sb.append(", replyTime=").append(replyTime);
        sb.append(", comment=").append(comment);
        sb.append(", userId=").append(userId);
        sb.append(", isRead=").append(isRead);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}