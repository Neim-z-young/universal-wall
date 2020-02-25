package com.freeLearn.wall.service;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.InsideFloorDetails;
import com.freeLearn.wall.dto.InsideFloorParam;
import com.freeLearn.wall.model.InsideFloor;

import java.util.List;

/**
 * 楼中楼服务
 */
public interface InsideFloorService {
    InsideFloor getById(Integer id);

    CommonResult deleteById(Integer id);

    CommonResult addNewReply(Integer userId, InsideFloorParam insideFloorParam);

    List<InsideFloorDetails> getAllByFloorId(Integer floorId);

}
