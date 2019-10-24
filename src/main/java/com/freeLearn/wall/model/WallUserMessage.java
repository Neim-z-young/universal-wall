package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallUserMessage {
    private Integer id;

    private Integer userId;

    private String message;  //key:value(theme:int;floor:int;inside_floor:int)
}
