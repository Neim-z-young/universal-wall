package com.freeLearn.wall.dao;

import com.freeLearn.wall.domain.PostingDetails;

//TODO making this to  be services
public interface PostingDetailsDao {
    PostingDetails selectByPrimaryKey(Integer postingId);

}
