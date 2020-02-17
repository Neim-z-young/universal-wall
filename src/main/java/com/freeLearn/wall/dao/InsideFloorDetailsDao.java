package com.freeLearn.wall.dao;

import com.freeLearn.wall.domain.InsideFloorDetails;

import java.util.List;

public interface InsideFloorDetailsDao {
    InsideFloorDetails getById(Integer insideFloorId);
    List<InsideFloorDetails> getByFloorId(Integer floorId);
    List<InsideFloorDetails> getByFloorId(Integer floorId, Integer pageNum, Integer pageSize);
}
