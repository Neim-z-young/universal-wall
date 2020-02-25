package com.freeLearn.wall.domain;

import com.freeLearn.wall.model.Floor;
import com.freeLearn.wall.model.InsideFloor;
import com.freeLearn.wall.model.Posting;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 帖子的详细内容
 * 包含用户评论(不包含楼中楼)
 * Create by oyoungy on 2019/10/26
 */
@Getter
@Setter
public class PostingDetails {
    private Integer id;
    private String theme;
    private String detailedIntroduction;
    private String pictureIntroduction;
    private Integer releaseTime;
    private Integer posterId;
    private Integer categoryId;
    private List<FloorBrief> floorListBrief;
}
