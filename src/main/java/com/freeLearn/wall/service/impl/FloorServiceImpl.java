package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.dao.FloorDetailsDao;
import com.freeLearn.wall.domain.FloorDetails;
import com.freeLearn.wall.dto.FloorParam;
import com.freeLearn.wall.mapper.FloorMapper;
import com.freeLearn.wall.mapper.PostingMapper;
import com.freeLearn.wall.model.Floor;
import com.freeLearn.wall.model.Posting;
import com.freeLearn.wall.service.FloorService;
import com.freeLearn.wall.util.DateUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.Date;

public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorDetailsDao floorDetailsDao;

    @Autowired
    private PostingMapper postingMapper;

    @Autowired
    private FloorMapper floorMapper;

    @Autowired
    private DateUtil dateUtil;

    @Override
    public FloorDetails listAllReply(Integer floorId) {
        return floorDetailsDao.selectByPrimaryKey(floorId);
    }

    @Override
    public FloorDetails listPagedReply(Integer floorId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return listAllReply(floorId);
    }

    @Override
    public CommonResult addNewComment(Integer userId, FloorParam floorParam) {
        Posting posting = postingMapper.selectByPrimaryKey(floorParam.getThemeId());
        if (posting != null) {
            Floor floor = new Floor();
            BeanUtils.copyProperties(floorParam, floor);
            floor.setUserId(userId);
            floor.setReplyTime(dateUtil.getEpochFromDate(new Date()));
            floor.setIsRead(false);
            int res = floorMapper.insert(floor);
            if (res > 0) {
                return CommonResult.success(null, "发布评论成功");
            }
        }
        return CommonResult.failed("发布评论失败!!");
    }
}
