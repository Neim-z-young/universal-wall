package com.freeLearn.wall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 回复帖子时用到的参数
 */
@Getter
@Setter
public class FloorParam {
    @ApiModelProperty(value = "评论内容", required = true)
    @NotEmpty(message = "评论不能为空")
    String comment;

//    @ApiModelProperty(value = "图片")
//    String pictureIntroduction;

    @ApiModelProperty(value = "帖子id", required = true)
    @NotNull(message = "帖子id不能为空")
    Integer themeId;
}
