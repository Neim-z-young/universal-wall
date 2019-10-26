package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.WallUser;

public interface WallUserMapper {
    WallUser selectByPrimaryKey(Integer id);

    WallUser selectByUsername(String username);

    WallUser selectByOpenId(String openId);

    int insert(WallUser record);

    int update(WallUser oldRecord, WallUser newRecord);

}
