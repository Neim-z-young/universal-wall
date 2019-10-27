package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.WallUserStatistic;
import com.freeLearn.wall.model.WallUserStatisticExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WallUserStatisticMapper {
    int countByExample(WallUserStatisticExample example);

    int deleteByExample(WallUserStatisticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WallUserStatistic record);

    int insertSelective(WallUserStatistic record);

    List<WallUserStatistic> selectByExample(WallUserStatisticExample example);

    WallUserStatistic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WallUserStatistic record, @Param("example") WallUserStatisticExample example);

    int updateByExample(@Param("record") WallUserStatistic record, @Param("example") WallUserStatisticExample example);

    int updateByPrimaryKeySelective(WallUserStatistic record);

    int updateByPrimaryKey(WallUserStatistic record);
}