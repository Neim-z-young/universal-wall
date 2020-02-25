package com.freeLearn.wall.service;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.FloorDetails;
import com.freeLearn.wall.dto.FloorParam;

/**
 * 帖子评论服务
 */
public interface FloorService {
    FloorDetails listAllReply(Integer floorId);

    FloorDetails listPagedReply(Integer floorId, Integer pageNum, Integer pageSize);

    CommonResult addNewComment(Integer userId, FloorParam floorParam);
}
