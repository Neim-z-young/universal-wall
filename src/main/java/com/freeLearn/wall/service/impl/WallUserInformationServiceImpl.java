package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.dao.WallUserDetailedInformationDao;
import com.freeLearn.wall.domain.WallUserDetailedInformation;
import com.freeLearn.wall.service.WallUserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WallUserInformationServiceImpl implements WallUserInformationService {
    @Autowired
    private WallUserDetailedInformationDao wallUserDetailedInformationDao;

    @Override
    public WallUserDetailedInformation getDetailedById(Integer userId) {
        return wallUserDetailedInformationDao.selectByPrimaryKey(userId);
    }
}
