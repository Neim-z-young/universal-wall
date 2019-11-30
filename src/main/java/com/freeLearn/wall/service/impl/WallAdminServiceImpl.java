package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.component.WallAdminDetailsService;
import com.freeLearn.wall.mapper.*;
import com.freeLearn.wall.model.*;
import com.freeLearn.wall.service.WallAdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WallAdminServiceImpl implements WallAdminService {
    protected static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    WallAdminMapper wallAdminMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolePermissionRelationMapper rolePermissionRelationMapper;

    @Autowired
    AdminRoleRelationMapper adminRoleRelationMapper;

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

    //TODO 查询优化
    @Override
    public List<Permission> getPermissionList(Integer adminId) {
        LOGGER.debug("Select admin " + adminId + "'s permissions");
        AdminRoleRelationExample example = new AdminRoleRelationExample();
        example.createCriteria().andAdminIdEqualTo(adminId);
        List<AdminRoleRelation> adminRoleRelations = adminRoleRelationMapper.selectByExample(example);
        Set<Integer> permissionIdSet = new HashSet<>();
        for(AdminRoleRelation adminRoleRelation : adminRoleRelations){
            RolePermissionRelationExample example1 = new RolePermissionRelationExample();
            example1.createCriteria().andRoleIdEqualTo(adminRoleRelation.getRoleId());
            List<RolePermissionRelation> rolePermissionRelations = rolePermissionRelationMapper.selectByExample(example1);
            for(RolePermissionRelation permissionRelation : rolePermissionRelations){
                permissionIdSet.add(permissionRelation.getPermissionId());
            }
        }
        List<Permission> permissionList = new ArrayList<>(permissionIdSet.size());
        for(Integer PerId : permissionIdSet){
            Permission permission = permissionMapper.selectByPrimaryKey(PerId);
            permissionList.add(permission);
        }
        LOGGER.debug("Select permissions ok");
        return permissionList;
    }
}
