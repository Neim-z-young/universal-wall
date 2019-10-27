package com.freeLearn.wall.model;

import java.io.Serializable;

public class PostingStatistic implements Serializable {
    private Integer id;

    private Integer themeId;

    // 点击次数
    private Integer clickTimes;

    // 最后修改时间
    private Integer lastModify;

    // 最后阅览时间
    private Integer lastView;

    private Integer posterId;

    private Integer categoryId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public Integer getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(Integer clickTimes) {
        this.clickTimes = clickTimes;
    }

    public Integer getLastModify() {
        return lastModify;
    }

    public void setLastModify(Integer lastModify) {
        this.lastModify = lastModify;
    }

    public Integer getLastView() {
        return lastView;
    }

    public void setLastView(Integer lastView) {
        this.lastView = lastView;
    }

    public Integer getPosterId() {
        return posterId;
    }

    public void setPosterId(Integer posterId) {
        this.posterId = posterId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", themeId=").append(themeId);
        sb.append(", clickTimes=").append(clickTimes);
        sb.append(", lastModify=").append(lastModify);
        sb.append(", lastView=").append(lastView);
        sb.append(", posterId=").append(posterId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}