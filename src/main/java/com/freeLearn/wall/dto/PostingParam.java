package com.freeLearn.wall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 帖子发布参数
 * Created by oyoungy on 2019/10/29.
 */
@Setter
@Getter
public class PostingParam {
    @ApiModelProperty(value = "帖子主题", required = true)
    @NotEmpty(message = "主题不能为空")
    String theme;

    @ApiModelProperty(value = "帖子内容", required = true)
    @NotEmpty(message = "描述不能为空")
    String detailedIntroduction;

    @ApiModelProperty(value = "图片")
    String pictureIntroduction;

    @ApiModelProperty(value = "类别id", required = true)
    Integer cateId;
}
