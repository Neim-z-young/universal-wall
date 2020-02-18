package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.WallUserInformation;
import com.freeLearn.wall.model.WallUserInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WallUserInformationMapper {
    long countByExample(WallUserInformationExample example);

    int deleteByExample(WallUserInformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WallUserInformation record);

    int insertSelective(WallUserInformation record);

    List<WallUserInformation> selectByExample(WallUserInformationExample example);

    WallUserInformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WallUserInformation record, @Param("example") WallUserInformationExample example);

    int updateByExample(@Param("record") WallUserInformation record, @Param("example") WallUserInformationExample example);

    int updateByPrimaryKeySelective(WallUserInformation record);

    int updateByPrimaryKey(WallUserInformation record);
}