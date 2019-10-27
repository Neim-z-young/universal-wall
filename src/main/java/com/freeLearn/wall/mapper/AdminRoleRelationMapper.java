package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.AdminRoleRelation;
import com.freeLearn.wall.model.AdminRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminRoleRelationMapper {
    int countByExample(AdminRoleRelationExample example);

    int deleteByExample(AdminRoleRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminRoleRelation record);

    int insertSelective(AdminRoleRelation record);

    List<AdminRoleRelation> selectByExample(AdminRoleRelationExample example);

    AdminRoleRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminRoleRelation record, @Param("example") AdminRoleRelationExample example);

    int updateByExample(@Param("record") AdminRoleRelation record, @Param("example") AdminRoleRelationExample example);

    int updateByPrimaryKeySelective(AdminRoleRelation record);

    int updateByPrimaryKey(AdminRoleRelation record);
}