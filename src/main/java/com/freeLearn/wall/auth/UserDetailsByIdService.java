package com.freeLearn.wall.auth;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsByIdService {
    UserDetails loadUserByUserId(Integer id);
}
