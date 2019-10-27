package com.freeLearn.wall.domain;

import com.freeLearn.wall.model.Permission;
import com.freeLearn.wall.model.WallAdmin;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class WallAdminDetails implements UserDetails {
    private WallAdmin admin;
    private List<Permission> permissionList;

    public WallAdminDetails(WallAdmin wallAdmin, List<Permission> permissionList){
        this.admin = wallAdmin;
        this.permissionList = permissionList;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return admin.getStatus();
    }
}
