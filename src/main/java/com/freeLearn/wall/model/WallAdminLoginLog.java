package com.freeLearn.wall.model;

import java.io.Serializable;

public class WallAdminLoginLog implements Serializable {
    private Integer id;

    private Integer adminId;

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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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
        sb.append(", adminId=").append(adminId);
        sb.append(", createTime=").append(createTime);
        sb.append(", ipAddress=").append(ipAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}