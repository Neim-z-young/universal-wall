package com.freeLearn.wall.mapper;

import com.freeLearn.wall.model.PostingStatistic;
import com.freeLearn.wall.model.PostingStatisticExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostingStatisticMapper {
    int countByExample(PostingStatisticExample example);

    int deleteByExample(PostingStatisticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PostingStatistic record);

    int insertSelective(PostingStatistic record);

    List<PostingStatistic> selectByExample(PostingStatisticExample example);

    PostingStatistic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PostingStatistic record, @Param("example") PostingStatisticExample example);

    int updateByExample(@Param("record") PostingStatistic record, @Param("example") PostingStatisticExample example);

    int updateByPrimaryKeySelective(PostingStatistic record);

    int updateByPrimaryKey(PostingStatistic record);
}