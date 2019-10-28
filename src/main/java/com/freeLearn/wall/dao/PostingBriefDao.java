package com.freeLearn.wall.dao;

import com.freeLearn.wall.domain.PostingBrief;

import java.util.List;

public interface PostingBriefDao {
    List<PostingBrief> listAll();

    List<PostingBrief> listAllByCateId(Integer cateId);

    List<PostingBrief> listAllByPosterId(Integer posterId);

}
