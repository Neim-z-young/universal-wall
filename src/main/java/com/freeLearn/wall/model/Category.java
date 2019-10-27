package com.freeLearn.wall.model;

import java.io.Serializable;

public class Category implements Serializable {
    private Integer id;

    // 帖子类别
    private String category;

    private String introduction;

    private Integer createTime;

    // 置顶帖
    private Integer topPostings;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getTopPostings() {
        return topPostings;
    }

    public void setTopPostings(Integer topPostings) {
        this.topPostings = topPostings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", category=").append(category);
        sb.append(", introduction=").append(introduction);
        sb.append(", createTime=").append(createTime);
        sb.append(", topPostings=").append(topPostings);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}