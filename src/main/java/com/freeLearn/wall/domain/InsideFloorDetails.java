package com.freeLearn.wall.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 楼中楼评论细节
 */
@Getter
@Setter
public class InsideFloorDetails {
    private Integer id;
    private Integer floorId;
    private Integer replyTime;
    private String comment;
    private Integer userId;

    private static final long serialVersionUID = 1L;
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", floorId=").append(floorId);
        sb.append(", replyTime=").append(replyTime);
        sb.append(", comment=").append(comment);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
