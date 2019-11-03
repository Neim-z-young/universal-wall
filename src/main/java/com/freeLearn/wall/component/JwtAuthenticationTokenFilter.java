package com.freeLearn.wall.component;


import com.freeLearn.wall.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * JWT登录授权过滤器
 * <p>
 * Create by oyoungy on 2019/10/25
 */
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    //TODO 配置路径
    public JwtAuthenticationTokenFilter() {
        super(new AntPathRequestMatcher("/login", "GET"));
    }

    //过滤器的授权行为应当委托给AuthenticationManager
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String authHeader = request.getHeader(this.tokenHeader);
        Authentication authentication = null;
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            String token = authHeader.substring(this.tokenHead.length() + 1); //authHeader = tokenHead + " " + token
            String username = jwtUtil.getUsernameFromToken(token);
            String role = jwtUtil.getRoleFromToken(token);
            authentication = new UsernamePasswordAuthenticationToken(username, role);
        }
        //交给authenticationProvider代理类进行授权
        return authentication;
    }
}
