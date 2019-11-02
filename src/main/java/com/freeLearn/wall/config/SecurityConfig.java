package com.freeLearn.wall.config;

import com.freeLearn.wall.auth.WallAdminAuthenticationProvider;
import com.freeLearn.wall.auth.WallUserAuthenticationProvider;
import com.freeLearn.wall.component.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 查阅spring-security文档后，学习到了可以配置多个securityConfiguration
 * Multiple HttpSecurity
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jwt.userRole}")
    private String ROLE_USER_PREFIX;

    @Value("${jwt.adminRole}")
    private String ROLE_ADMIN_PREFIX;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestfulAuthenticationEntryPoint restfulAuthenticationEntryPoint;

    @Bean
    public WallUserDetailsService userDetailsService() {
        return new WallUserDetailsService();
    }

    @Bean
    public WallAdminDetailsService adminDetailsService() {
        return new WallAdminDetailsService();
    }

    //jwt Filter
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
        //spring会拦截@Bean方法的调用
        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
        //TODO set auth success/failed handler

        return jwtAuthenticationTokenFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WallAdminAuthenticationProvider wallAdminAuthenticationProvider(){
        WallAdminAuthenticationProvider wallAdminAuthenticationProvider = new WallAdminAuthenticationProvider();
        //spring会拦截@Bean方法的调用
        wallAdminAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        wallAdminAuthenticationProvider.setUserDetailsService(adminDetailsService());
        wallAdminAuthenticationProvider.setROLE_ADMIN_PREFIX(ROLE_ADMIN_PREFIX);
        return wallAdminAuthenticationProvider;
    }

    @Bean
    public WallUserAuthenticationProvider wallUserAuthenticationProvider(){
        WallUserAuthenticationProvider wallUserAuthenticationProvider = new WallUserAuthenticationProvider();
        //spring会拦截@Bean方法的调用
        wallUserAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        wallUserAuthenticationProvider.setROLE_USER_PREFIX(ROLE_USER_PREFIX);
        wallUserAuthenticationProvider.setUserDetailsService(userDetailsService());
        return wallUserAuthenticationProvider;
    }

    //配置Spring Security 的Filter链
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    //配置如何通过拦截器保护请求
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                    .permitAll()
                .anyRequest()
                    .permitAll()
                .and()
                .requiresChannel()  //增加https
                    .antMatchers("/**")
                        .requiresSecure();

        http.csrf().disable();

        // 禁用缓存（不使用session，故基本用不上缓存）
        http.headers().cacheControl();
        //避免因认证过滤器跳过其后的所有过滤器，导致jwt Filter失效
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录的返回结果
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restfulAuthenticationEntryPoint);
    }

    /**
     * 认证配置的多个authenticationProvider
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //配置userDetailsService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(wallAdminAuthenticationProvider())
                .authenticationProvider(wallUserAuthenticationProvider());
    }

}
