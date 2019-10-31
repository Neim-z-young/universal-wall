package com.freeLearn.wall.component;

import com.freeLearn.wall.domain.WallAdminDetails;
import com.freeLearn.wall.domain.WallUserDetails;
import com.freeLearn.wall.model.Permission;
import com.freeLearn.wall.model.WallAdmin;
import com.freeLearn.wall.model.WallUser;
import com.freeLearn.wall.service.WallAdminService;
import com.freeLearn.wall.service.WallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

public class WallUserDetailsService implements UserDetailsService {

    @Autowired
    WallUserService wallUserService;


    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        WallUser wallUser = wallUserService.getByUsername(username);
        if (wallUser != null) {
            userDetails = new WallUserDetails(wallUser);
            return userDetails;
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
