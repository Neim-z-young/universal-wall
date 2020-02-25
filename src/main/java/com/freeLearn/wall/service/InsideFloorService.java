package com.freeLearn.wall.service;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.dto.InsideFloorParam;

/**
 * 楼中楼服务
 */
public interface InsideFloorService {
    CommonResult addNewReply(Integer userId, InsideFloorParam insideFloorParam);
}
