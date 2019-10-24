package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WallUserStatistic {
    private Integer id;

    private Integer userId;

    private Integer postingsNum;

    private Integer unreadMessages;
}
