package com.freeLearn.wall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Permission implements Serializable {
    private Integer id;

    // 用户权限
    @ApiModelProperty(value = "用户权限")
    private String peimission;

    private String introduction;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeimission() {
        return peimission;
    }

    public void setPeimission(String peimission) {
        this.peimission = peimission;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", peimission=").append(peimission);
        sb.append(", introduction=").append(introduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}