package com.freeLearn.wall.component;

import com.freeLearn.wall.domain.WallAdminDetails;
import com.freeLearn.wall.model.Permission;
import com.freeLearn.wall.model.WallAdmin;
import com.freeLearn.wall.service.WallAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

public class WallAdminDetailsService implements UserDetailsService {

    @Autowired
    WallAdminService wallAdminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        WallAdmin wallAdmin = wallAdminService.getByUsername(username);
        if(wallAdmin!=null){
            //TODO 权限
            List<Permission> permissionList = wallAdminService.getPermissionList(wallAdmin.getId());
            userDetails = new WallAdminDetails(wallAdmin, permissionList);
            return userDetails;
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
