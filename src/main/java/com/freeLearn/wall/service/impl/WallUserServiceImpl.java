package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.model.WallUser;
import com.freeLearn.wall.service.WallUserService;

/**
 * 用户服务实现类
 * Create by oyoungy on 2019/10/26
 */
public class WallUserServiceImpl implements WallUserService {
    @Override
    public WallUser getByUsername(String username) {
        return null;
    }

    @Override
    public WallUser getByUserId(Integer userId) {
        return null;
    }

    @Override
    public WallUser getByOpenId(String openId) {
        return null;
    }

    @Override
    public CommonResult register(String username, String password) {
        return null;
    }

    @Override
    public CommonResult updatePassword(String username, String oldPassword, String newPassword, String confirmPassword) {
        return null;
    }

    @Override
    public WallUser getCurrentUser() {
        return null;
    }

    @Override
    public void updateNickName(Integer userId, String newNickName) {

    }


    @Override
    public void updateGrowth(Integer userId, Integer growth) {

    }

    @Override
    public void updatePoints(Integer userId, Integer newPoints) {

    }
}
