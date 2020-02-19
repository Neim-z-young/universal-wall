package com.freeLearn.wall.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 评论细节
 */
@Setter
@Getter
public class FloorDetails {
    private Integer id;
    private Integer themeId;
    private Integer replyTime;
    private String comment;
    private Integer userId;
    private List<InsideFloorDetails> insideFloorDetailList;
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
        sb.append(", insideFloors=[");
        for (InsideFloorDetails details:insideFloorDetailList)
            sb.append(details);
        sb.append("], serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
