package com.freeLearn.wall.service;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.model.WallUser;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 * Create by oyoungy on 2019/10/25
 */
@Service
public interface WallUserService {
    /**
     * 通过username查找用户
     * @param username
     * @return
     */
    WallUser getByUsername(String username);

    /**
     * 通过userId查找用户
     * @param userId
     * @return
     */
    WallUser getByUserId(Integer userId);

    /**
     * 通过openId查找用户
     * @param openId
     * @return
     */
    WallUser getByOpenId(String openId);

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    CommonResult register(String username, String password);

    /**
     * 修改密码
     * @param username
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     * @return
     */
    CommonResult updatePassword(String username, String oldPassword, String newPassword, String confirmPassword);

    /**
     * 获取当前登录用户
     * @return
     */
    WallUser getCurrentUser();

    /**
     * 修改昵称
     * @param newNickName
     */
    void updateNickName(Integer userId, String newNickName);

    /**
     * 更新成长值
     * @param userId
     * @param growth
     */
    void updateGrowth(Integer userId, Integer growth);

    /**
     * 更新积分
     * @param userId
     * @param newPoints
     */
    void updatePoints(Integer userId, Integer newPoints);
}
