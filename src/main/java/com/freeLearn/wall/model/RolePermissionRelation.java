package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolePermissionRelation {
    private Integer id;

    private Integer permissionId;

    private Integer roleId;
}
