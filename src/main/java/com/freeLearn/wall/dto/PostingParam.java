package com.freeLearn.wall.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Setter
@Getter
public class PostingParam {
    @NotEmpty(message = "主题不能为空")
    String theme;
    @NotEmpty(message = "描述不能为空")
    String detailedIntroduction;
    String pictureIntroduction;
    @NotEmpty(message = "分类不能为空")
    Integer cateId;
}
