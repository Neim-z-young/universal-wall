package com.freeLearn.wall.dao;

import com.freeLearn.wall.domain.FloorDetails;

import java.util.List;

public interface FloorDetailsDao {
    FloorDetails getById(Integer floorId);
    List<FloorDetails> getByPostId(Integer postingId);
    List<FloorDetails> getByPostId(Integer postingId, Integer pageNum, Integer pageSize);
}
