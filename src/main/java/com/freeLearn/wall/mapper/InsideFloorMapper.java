package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.InsideFloor;
import com.freeLearn.wall.model.InsideFloorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsideFloorMapper {
    int countByExample(InsideFloorExample example);

    int deleteByExample(InsideFloorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InsideFloor record);

    int insertSelective(InsideFloor record);

    List<InsideFloor> selectByExample(InsideFloorExample example);

    InsideFloor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InsideFloor record, @Param("example") InsideFloorExample example);

    int updateByExample(@Param("record") InsideFloor record, @Param("example") InsideFloorExample example);

    int updateByPrimaryKeySelective(InsideFloor record);

    int updateByPrimaryKey(InsideFloor record);
}