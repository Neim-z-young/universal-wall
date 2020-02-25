package com.freeLearn.wall.domain;

import lombok.Getter;
import lombok.Setter;


/**
 * 评论内容
 * 不包含楼中楼
 * 通过replyCount计数回复的个数
 */
@Getter
@Setter
public class FloorBrief {
    private Integer id;
    private Integer themeId;
    private Integer replyTime;
    private String comment;
    private Integer userId;
    //TODO add to db table
    private Integer replyCount;
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", themeId=").append(themeId);
        sb.append(", replyTime=").append(replyTime);
        sb.append(", comment=").append(comment);
        sb.append(", userId=").append(userId);
        sb.append(", replyCount=").append(replyCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
