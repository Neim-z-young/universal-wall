package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.dao.PostingStatisticDao;
import com.freeLearn.wall.mapper.PostingStatisticMapper;
import com.freeLearn.wall.model.Posting;
import com.freeLearn.wall.model.PostingStatistic;
import com.freeLearn.wall.model.PostingStatisticExample;
import com.freeLearn.wall.service.PostingStatisticService;
import com.freeLearn.wall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class PostingStatisticServiceImpl implements PostingStatisticService {
    @Autowired
    private PostingStatisticMapper postingStatisticMapper;

    @Autowired
    private PostingStatisticDao postingStatisticDao;

    @Autowired
    private DateUtil dateUtil;

    @Override
    public Integer addDefault(Posting posting) {
        PostingStatistic postingStatistic = new PostingStatistic();
        postingStatistic.setCategoryId(posting.getCategoryId());
        postingStatistic.setClickTimes(0);
        Integer curTime = dateUtil.getEpochFromDate(new Date());
        postingStatistic.setLastModify(curTime);
        postingStatistic.setLastView(curTime);
        postingStatistic.setPosterId(posting.getPosterId());
        postingStatistic.setThemeId(posting.getId());
        return postingStatisticMapper.insert(postingStatistic);
    }

    @Override
    public Integer updateClickStatics(Integer postingId) {
        PostingStatisticExample example = new PostingStatisticExample();
        example.createCriteria().andThemeIdEqualTo(postingId);
        PostingStatistic postingStatistic = new PostingStatistic();
        postingStatistic.setLastView(dateUtil.getEpochFromDate(new Date()));
        postingStatisticMapper.updateByExampleSelective(postingStatistic, example);
        return postingStatisticDao.addClickTimes(postingId);
    }
}
