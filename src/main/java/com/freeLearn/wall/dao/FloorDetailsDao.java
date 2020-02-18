package com.freeLearn.wall.dao;

import com.freeLearn.wall.domain.FloorDetails;

import java.util.List;

public interface FloorDetailsDao {
    FloorDetails selectByPrimaryKey(Integer floorId);
    List<FloorDetails> selectByPostingId(Integer postingId);
}
