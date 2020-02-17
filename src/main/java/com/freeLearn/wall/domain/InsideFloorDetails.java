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
}
