package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Integer id;

    private String category;

    private String introduction;

    private Integer createTime;

    private Integer topPostings; //相应类别的置顶帖子id
}
