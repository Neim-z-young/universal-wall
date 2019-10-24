package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Floor {
    private Integer id;

    private Integer themeId;

    private Integer replyTime;

    private String comment;

    private Integer userId;

    private Boolean isRead;
}
