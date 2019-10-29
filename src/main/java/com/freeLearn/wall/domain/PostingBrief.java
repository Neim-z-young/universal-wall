package com.freeLearn.wall.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 贴子的简略信息
 *  * 作用：
 *     适应前端显示
 *
 * Create by oyoungy on 2019/10/26
 */
@Setter
@Getter
public class PostingBrief {
    private Integer id;
    private String theme;
    private String briefIntroduction;
//    private String pictureIntroduction;
    private Integer releaseTime;
    private Integer posterId;
    private Integer categoryId;
    private Integer clickTimes;
}
