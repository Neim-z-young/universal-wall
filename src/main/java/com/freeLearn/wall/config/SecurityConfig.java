package com.freeLearn.wall.config;

import com.freeLearn.wall.component.JwtAuthenticationTokenFilter;
import com.freeLearn.wall.component.RestfulAccessDeniedHandler;
import com.freeLearn.wall.component.RestfulAuthenticationEntryPoint;
import com.freeLearn.wall.domain.WallAdminDetails;
import com.freeLearn.wall.domain.WallUserDetails;
import com.freeLearn.wall.model.Permission;
import com.freeLearn.wall.model.WallAdmin;
import com.freeLearn.wall.model.WallUser;
import com.freeLearn.wall.service.WallUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private WallUserService wallUserService;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestfulAuthenticationEntryPoint restfulAuthenticationEntryPoint;


    //配置Spring Security 的Filter链
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    //配置如何通过拦截器保护请求
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
                .and()
                .formLogin().and()
                .httpBasic();

        // 禁用缓存（不使用session，故基本用不上缓存）
        http.headers().cacheControl();
        //提供jwt Filter支持，在认证过滤器前，先进行jwt过滤器认证
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录的返回结果
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restfulAuthenticationEntryPoint);
    }

    //配置userDetailsService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())  //使用自定义后台用户服务
                .passwordEncoder(passwordEncoder());   //加密方式
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //TODO 将前后端的userDetailsService分离，前端不同，提供的用户服务也有所差别
    //前端用户，唯一username
    //TODO 完善微信端用户服务，
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            WallUser wallUser = wallUserService.getByUsername(username);
            if(wallUser!=null){
                return new WallUserDetails(wallUser);
            }
          throw new UsernameNotFoundException("用户名或密码错误");
        };
    }

    //jwt Filter
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }
}
