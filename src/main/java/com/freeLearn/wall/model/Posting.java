package com.freeLearn.wall.model;

import java.io.Serializable;

public class Posting implements Serializable {
    private Integer id;

    // 帖子主题
    private String theme;

    // 简易说明，由后端截取
    private String briefIntroduction;

    // 详细说明
    private String detailedIntroduction;

    // 图片说明
    private String pictureIntroduction;

    private Integer releaseTime;

    // 发帖者id
    private Integer posterId;

    private Integer categoryId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getDetailedIntroduction() {
        return detailedIntroduction;
    }

    public void setDetailedIntroduction(String detailedIntroduction) {
        this.detailedIntroduction = detailedIntroduction;
    }

    public String getPictureIntroduction() {
        return pictureIntroduction;
    }

    public void setPictureIntroduction(String pictureIntroduction) {
        this.pictureIntroduction = pictureIntroduction;
    }

    public Integer getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Integer releaseTime) {
        this.releaseTime = releaseTime;
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
        sb.append(", theme=").append(theme);
        sb.append(", briefIntroduction=").append(briefIntroduction);
        sb.append(", detailedIntroduction=").append(detailedIntroduction);
        sb.append(", pictureIntroduction=").append(pictureIntroduction);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", posterId=").append(posterId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}