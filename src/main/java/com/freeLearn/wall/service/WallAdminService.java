package com.freeLearn.wall.service;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.model.Permission;
import com.freeLearn.wall.model.WallAdmin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员服务
 * Create by oyoungy on 2019/10/26
 */
@Service
public interface WallAdminService {
    /**
     * 通过username查找后台用户
     * @param username
     * @return
     */
    WallAdmin getByUsername(String username);

    /**
     * 通过userId查找后台用户
     * @param userId
     * @return
     */
    WallAdmin getByAdminId(Integer userId);

    /**
     * 后台用户注册
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
     * 获取当前登录的后台用户
     * @return
     */
    WallAdmin getCurrentUser();

    /**
     * 修改昵称
     * @param newNickName
     */
    void updateNickName(String newNickName);

    /**
     * 获取后台用户权限列表
     * @param adminId
     * @return
     */
    List<Permission> getPermissionList(Integer adminId);
}
