package com.freeLearn.wall.config;

import com.freeLearn.wall.domain.WallAdminDetails;
import com.freeLearn.wall.model.Permission;
import com.freeLearn.wall.model.WallAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


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

        //TODO 提供jwtToken 支持
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

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            WallAdmin wallAdmin=null;   //认证管理员
            if(wallAdmin!=null){
                List<Permission> permissionList = null;
                return new WallAdminDetails(wallAdmin, permissionList);
            }
          throw new UsernameNotFoundException("用户名或密码错误");
        };
    }
}
