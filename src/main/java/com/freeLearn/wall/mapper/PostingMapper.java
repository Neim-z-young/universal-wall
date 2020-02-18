package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.Posting;
import com.freeLearn.wall.model.PostingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostingMapper {
    long countByExample(PostingExample example);

    int deleteByExample(PostingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Posting record);

    int insertSelective(Posting record);

    List<Posting> selectByExample(PostingExample example);

    Posting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Posting record, @Param("example") PostingExample example);

    int updateByExample(@Param("record") Posting record, @Param("example") PostingExample example);

    int updateByPrimaryKeySelective(Posting record);

    int updateByPrimaryKey(Posting record);
}