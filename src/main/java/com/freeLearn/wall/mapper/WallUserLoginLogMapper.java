package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.WallUserLoginLog;
import com.freeLearn.wall.model.WallUserLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WallUserLoginLogMapper {
    long countByExample(WallUserLoginLogExample example);

    int deleteByExample(WallUserLoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WallUserLoginLog record);

    int insertSelective(WallUserLoginLog record);

    List<WallUserLoginLog> selectByExample(WallUserLoginLogExample example);

    WallUserLoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WallUserLoginLog record, @Param("example") WallUserLoginLogExample example);

    int updateByExample(@Param("record") WallUserLoginLog record, @Param("example") WallUserLoginLogExample example);

    int updateByPrimaryKeySelective(WallUserLoginLog record);

    int updateByPrimaryKey(WallUserLoginLog record);
}