package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.WallAdminLoginLog;
import com.freeLearn.wall.model.WallAdminLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WallAdminLoginLogMapper {
    int countByExample(WallAdminLoginLogExample example);

    int deleteByExample(WallAdminLoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WallAdminLoginLog record);

    int insertSelective(WallAdminLoginLog record);

    List<WallAdminLoginLog> selectByExample(WallAdminLoginLogExample example);

    WallAdminLoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WallAdminLoginLog record, @Param("example") WallAdminLoginLogExample example);

    int updateByExample(@Param("record") WallAdminLoginLog record, @Param("example") WallAdminLoginLogExample example);

    int updateByPrimaryKeySelective(WallAdminLoginLog record);

    int updateByPrimaryKey(WallAdminLoginLog record);
}