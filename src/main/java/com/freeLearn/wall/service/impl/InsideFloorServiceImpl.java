package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.dto.InsideFloorParam;
import com.freeLearn.wall.mapper.FloorMapper;
import com.freeLearn.wall.mapper.InsideFloorMapper;
import com.freeLearn.wall.model.Floor;
import com.freeLearn.wall.model.InsideFloor;
import com.freeLearn.wall.service.InsideFloorService;
import com.freeLearn.wall.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class InsideFloorServiceImpl implements InsideFloorService {
    @Autowired
    private FloorMapper floorMapper;

    @Autowired
    private InsideFloorMapper insideFloorMapper;

    @Autowired
    private DateUtil dateUtil;

    @Override
    public CommonResult addNewReply(Integer userId, InsideFloorParam insideFloorParam) {
        Floor floor = floorMapper.selectByPrimaryKey(insideFloorParam.getFloorId());
        if(floor!=null){
            InsideFloor insideFloor = new InsideFloor();
            BeanUtils.copyProperties(insideFloorParam, insideFloor);
            insideFloor.setUserId(userId);
            insideFloor.setReplyTime(dateUtil.getEpochFromDate(new Date()));
            insideFloor.setIsRead(false);
            int res = insideFloorMapper.insert(insideFloor);
            if(res>0)
                return CommonResult.success(null, "回复成功");
        }
        return CommonResult.failed("回复失败！！");
    }
}
