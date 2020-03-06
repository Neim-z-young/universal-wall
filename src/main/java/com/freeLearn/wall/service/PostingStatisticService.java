package com.freeLearn.wall.service;

import com.freeLearn.wall.model.Posting;

public interface PostingStatisticService {
    Integer addDefault(Posting posting);
    Integer updateClickStatics(Integer postingId);
}
