package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.RolePermissionRelation;
import com.freeLearn.wall.model.RolePermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionRelationMapper {
    int countByExample(RolePermissionRelationExample example);

    int deleteByExample(RolePermissionRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePermissionRelation record);

    int insertSelective(RolePermissionRelation record);

    List<RolePermissionRelation> selectByExample(RolePermissionRelationExample example);

    RolePermissionRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePermissionRelation record, @Param("example") RolePermissionRelationExample example);

    int updateByExample(@Param("record") RolePermissionRelation record, @Param("example") RolePermissionRelationExample example);

    int updateByPrimaryKeySelective(RolePermissionRelation record);

    int updateByPrimaryKey(RolePermissionRelation record);
}