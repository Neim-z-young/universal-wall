package com.freeLearn.wall.service;

import com.freeLearn.wall.domain.WallUserDetailedInformation;
import org.springframework.stereotype.Service;

/**
 * 用户详细信息服务
 * Create by oyoungy on 2019/10/26
 */

public interface WallUserInformationService {
    WallUserDetailedInformation getDetailedById(Integer userId);
}
