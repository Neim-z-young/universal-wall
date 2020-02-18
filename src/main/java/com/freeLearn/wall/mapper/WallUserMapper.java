package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.WallUser;
import com.freeLearn.wall.model.WallUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WallUserMapper {
    long countByExample(WallUserExample example);

    int deleteByExample(WallUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WallUser record);

    int insertSelective(WallUser record);

    List<WallUser> selectByExample(WallUserExample example);

    WallUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WallUser record, @Param("example") WallUserExample example);

    int updateByExample(@Param("record") WallUser record, @Param("example") WallUserExample example);

    int updateByPrimaryKeySelective(WallUser record);

    int updateByPrimaryKey(WallUser record);
}