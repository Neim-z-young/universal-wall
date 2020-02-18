package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.WallAdmin;
import com.freeLearn.wall.model.WallAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WallAdminMapper {
    long countByExample(WallAdminExample example);

    int deleteByExample(WallAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WallAdmin record);

    int insertSelective(WallAdmin record);

    List<WallAdmin> selectByExample(WallAdminExample example);

    WallAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WallAdmin record, @Param("example") WallAdminExample example);

    int updateByExample(@Param("record") WallAdmin record, @Param("example") WallAdminExample example);

    int updateByPrimaryKeySelective(WallAdmin record);

    int updateByPrimaryKey(WallAdmin record);
}