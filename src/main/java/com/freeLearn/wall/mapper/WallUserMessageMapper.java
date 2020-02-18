package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.WallUserMessage;
import com.freeLearn.wall.model.WallUserMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WallUserMessageMapper {
    long countByExample(WallUserMessageExample example);

    int deleteByExample(WallUserMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WallUserMessage record);

    int insertSelective(WallUserMessage record);

    List<WallUserMessage> selectByExample(WallUserMessageExample example);

    WallUserMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WallUserMessage record, @Param("example") WallUserMessageExample example);

    int updateByExample(@Param("record") WallUserMessage record, @Param("example") WallUserMessageExample example);

    int updateByPrimaryKeySelective(WallUserMessage record);

    int updateByPrimaryKey(WallUserMessage record);
}