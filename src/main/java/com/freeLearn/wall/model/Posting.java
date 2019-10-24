package com.freeLearn.wall.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Posting {
    private Integer id;

    private String theme;

    private String briefIntroduction;

    private String detailedIntroduction;

    private String pictureIntroduction;

    private Integer releaseTime;

    private Integer posterId;

    private Integer categoryId;
}
