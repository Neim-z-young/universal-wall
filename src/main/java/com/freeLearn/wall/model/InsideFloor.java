package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsideFloor {
    private Integer id;

    private Integer floorId;

    private Integer replyTime;

    private String comment;

    private Integer userId;

    private Boolean isRead;
}
