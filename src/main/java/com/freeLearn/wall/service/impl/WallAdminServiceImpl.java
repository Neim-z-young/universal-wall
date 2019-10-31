package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.component.WallAdminDetailsService;
import com.freeLearn.wall.mapper.WallAdminMapper;
import com.freeLearn.wall.model.Permission;
import com.freeLearn.wall.model.WallAdmin;
import com.freeLearn.wall.model.WallAdminExample;
import com.freeLearn.wall.service.WallAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class WallAdminServiceImpl implements WallAdminService {
    @Autowired
    WallAdminMapper wallAdminMapper;

    @Autowired
    WallAdminDetailsService adminDetailsService;

    @Override
    public WallAdmin getByUsername(String username) {
        WallAdminExample example = new WallAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<WallAdmin> adminList = wallAdminMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(adminList)){
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public WallAdmin getByAdminId(Integer userId) {
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
    public WallAdmin getCurrentUser() {
        return null;
    }

    @Override
    public void updateNickName(String newNickName) {

    }

    @Override
    public List<Permission> getPermissionList(Integer adminId) {
        return null;
    }
}
