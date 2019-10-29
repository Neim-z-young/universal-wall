package com.freeLearn.wall.auth;

import com.freeLearn.wall.domain.WallUserDetails;
import com.freeLearn.wall.util.JwtUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

@Getter
@Setter
public class WallUserAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private String ROLE_USER_PREFIX;
    private PasswordEncoder passwordEncoder;
    private UserDetailsService userDetailsService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if(!(authentication.getCredentials() instanceof String)){
            return null;
        }
        String role = (String)authentication.getCredentials();
        UserDetails userDetails = null;
        if(role.equals(ROLE_USER_PREFIX)){
            userDetails = userDetailsService.loadUserByUsername(username);
        }
        return userDetails;
    }

    /**
     * 授权成功时返回的授权对象
     * 将userDetail保存在principal中
     * @param principal
     * @param authentication
     * @param user
     * @return
     */
    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication,
                                                         UserDetails user) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
        authenticationToken.setDetails(authentication.getDetails());
        return authenticationToken;
    }
}
