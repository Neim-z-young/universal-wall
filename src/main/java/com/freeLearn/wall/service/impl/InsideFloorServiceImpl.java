package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.dao.InsideFloorDetailsDao;
import com.freeLearn.wall.domain.InsideFloorDetails;
import com.freeLearn.wall.dto.InsideFloorParam;
import com.freeLearn.wall.mapper.FloorMapper;
import com.freeLearn.wall.mapper.InsideFloorMapper;
import com.freeLearn.wall.model.Floor;
import com.freeLearn.wall.model.InsideFloor;
import com.freeLearn.wall.service.InsideFloorService;
import com.freeLearn.wall.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InsideFloorServiceImpl implements InsideFloorService {
    @Autowired
    private FloorMapper floorMapper;

    @Autowired
    private InsideFloorMapper insideFloorMapper;

    @Autowired
    private InsideFloorDetailsDao insideFloorDetailsDao;

    @Autowired
    private DateUtil dateUtil;

    @Override
    public InsideFloor getById(Integer id) {
        return insideFloorMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonResult deleteById(Integer id) {
        int res = insideFloorMapper.deleteByPrimaryKey(id);
        if(res>0){
            return CommonResult.success(null, "删除成功");
        }
        return CommonResult.failed("删除失败");
    }

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

    @Override
    public List<InsideFloorDetails> getAllByFloorId(Integer floorId) {
        return insideFloorDetailsDao.selectByFloorId(floorId);
    }
}
