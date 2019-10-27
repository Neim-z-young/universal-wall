package com.freeLearn.wall.model;

import java.io.Serializable;

public class WallUserLoginLog implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer createTime;

    // 通过INET_ATON()/INET_NTOA()转换
    private Long ipAddress;

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

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Long getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(Long ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", ipAddress=").append(ipAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}