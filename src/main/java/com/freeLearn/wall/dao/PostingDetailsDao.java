package com.freeLearn.wall.dao;

import com.freeLearn.wall.domain.PostingDetails;

public interface PostingDetailsDao {
    PostingDetails getById(Integer postingId);
}
