package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.dao.WallUserDetailedInformationDao;
import com.freeLearn.wall.domain.WallUserDetailedInformation;
import com.freeLearn.wall.service.WallUserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WallUserCenterServiceImpl implements WallUserCenterService {
    @Autowired
    private WallUserDetailedInformationDao wallUserDetailedInformationDao;

    @Override
    public CommonResult getDetailedInformation(Integer id) {
        WallUserDetailedInformation information = wallUserDetailedInformationDao.selectByPrimaryKey(id);
        if(information==null){
            CommonResult.failed("用户不存在");
        }
        return CommonResult.success(information, "用户查询成功");
    }

    @Override
    public CommonResult getDetailedInformation(String username) {
        WallUserDetailedInformation information = wallUserDetailedInformationDao.selectByUsername(username);
        if(information==null){
            CommonResult.failed("用户不存在");
        }
        return CommonResult.success(information, "用户查询成功");
    }
}
