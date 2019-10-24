package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostingStatistic {
    private Integer id;

    private Integer themeId;

    private Integer clickTimes;

    private Integer lastModify;

    private Integer lastView;

    private Integer posterId;

    private Integer categoryId;
}
