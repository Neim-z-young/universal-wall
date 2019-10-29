package com.freeLearn.wall.dao;

import com.freeLearn.wall.domain.WallUserDetailedInformation;

/**
 * Create by oyoungy on 2019/10/29
 */
public interface WallUserDetailedInformationDao {
    WallUserDetailedInformation selectByPrimaryKey(Integer id);
    WallUserDetailedInformation selectByUsername(String username);
}
