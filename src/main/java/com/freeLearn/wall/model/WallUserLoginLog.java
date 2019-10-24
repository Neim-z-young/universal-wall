package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallUserLoginLog {
    private Integer id;
    private Integer userId;
    private Integer createTime;
    private Long ipAddress;
}
