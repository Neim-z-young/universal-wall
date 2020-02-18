package com.freeLearn.wall.dao;

import com.freeLearn.wall.domain.InsideFloorDetails;

import java.util.List;

public interface InsideFloorDetailsDao {
    InsideFloorDetails selectByPrimaryKey(Integer insideFloorId);
    List<InsideFloorDetails> selectByFloorId(Integer floorId);
}
