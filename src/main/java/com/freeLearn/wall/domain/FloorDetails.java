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
    private List<InsideFloorDetails> insideFloorListDetail;
}
