package com.freeLearn.wall.auth;

import com.freeLearn.wall.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码登录授权过滤器
 * 登录过滤器应当作用在某个具体的请求上
 * //TODO 验证码功能未完成
 * <p>
 * Create by oyoungy on 2019/11/5
 */
public class AuthCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    //TODO 配置路径
    public AuthCodeAuthenticationFilter() {
        super(new AntPathRequestMatcher("/authCode/login"));
    }

    //过滤器的授权行为应当委托给AuthenticationManager
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        Authentication authentication = null;
        authentication = this.getAuthenticationManager().authenticate(authentication);
        throw new AccountExpiredException("token无效或已过期");
    }
}
