package com.freeLearn.wall.service;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.PostingBrief;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户中心服务
 * Create by oyoungy on 2019/10/26
 */

public interface WallUserCenterService {
    CommonResult getDetailedInformation(Integer id);
    CommonResult getDetailedInformation(String username);
}
