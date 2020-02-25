package com.freeLearn.wall.dao;

import com.freeLearn.wall.domain.FloorBrief;

import java.util.List;

public interface FloorBriefDao {
    FloorBrief selectByPrimaryKey(Integer floorId);
    List<FloorBrief> selectByPostingId(Integer postingId);
}
