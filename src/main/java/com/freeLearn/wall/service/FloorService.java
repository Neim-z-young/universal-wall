package com.freeLearn.wall.service;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.FloorBrief;
import com.freeLearn.wall.domain.FloorDetails;
import com.freeLearn.wall.dto.FloorParam;
import com.freeLearn.wall.model.Floor;

import java.util.List;

/**
 * 帖子评论服务
 */
public interface FloorService {
    Floor getById(Integer id);

    CommonResult deleteById(Integer id);

    List<FloorBrief> listAllByPostingId(Integer postingId);

    List<FloorBrief> listPageNumByPostingId(Integer postingId, Integer pageNum, Integer pageSize);

    FloorDetails listAllReply(Integer floorId);

    FloorDetails listPageNumReply(Integer floorId, Integer pageNum, Integer pageSize);

    CommonResult addNewComment(Integer userId, FloorParam floorParam);
}
