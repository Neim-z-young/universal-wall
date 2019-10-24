package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRoleRelation {
    private Integer id;

    private Integer adminId;

    private Integer roleId;
}
