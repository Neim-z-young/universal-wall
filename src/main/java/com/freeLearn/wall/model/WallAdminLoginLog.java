package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallAdminLoginLog {
    private Integer id;
    private Integer adminId;
    private Integer createTime;
    private Long ipAddress;
}
