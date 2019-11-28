package com.freeLearn.wall.auth;


import com.freeLearn.wall.util.JwtUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * JWT登录授权过滤器
 * token过滤器应当作用所有请求上(oncePerRequest)
 *
 * Create by oyoungy on 2019/10/25
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    protected static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    //进行认证
    @Getter
    @Setter
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationTokenFilter() {

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader(this.tokenHeader);
        Authentication authentication = null;
        LOGGER.debug("AuthHeader: " + authHeader);
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            String token = authHeader.substring(this.tokenHead.length() + 1); //authHeader = tokenHead + " " + token
            if (!jwtUtil.isTokenExpired(token)) {
                String username = jwtUtil.getUsernameFromToken(token);
                String role = jwtUtil.getRoleFromToken(token);
                LOGGER.debug("TOKEN: " + token + " username: " + username + " role: " + role);
                authentication = new UsernamePasswordAuthenticationToken(username, role);
                try{
                    //交给authenticationProvider代理类进行授权
                    authentication = this.getAuthenticationManager().authenticate(authentication);
                    processTokenAuthentication(authentication);
                }catch (AuthenticationException e){
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * 认证成功后的处理操作
     * @param authentication
     */
    private void processTokenAuthentication(Authentication authentication){
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
