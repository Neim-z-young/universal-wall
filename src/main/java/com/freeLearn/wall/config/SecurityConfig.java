package com.freeLearn.wall.config;

import com.freeLearn.wall.auth.JwtAuthenticationTokenFilter;
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
import org.springframework.security.config.http.SessionCreationPolicy;
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

    //可配置不通过 Web Security 的拦截过滤的url
    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略对以下资源的拦截及过滤
        //不进行security操作
//        web.ignoring()
//                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问(主要是swagger相关资源)
//                "/",
//                "/**/*.*",
//                "/*.html",
//                "/favicon.ico",
//                "/**/*.html",
//                "/**/*.css",
//                "/**/*.js",
//                "/swagger-resources/**",
//                "/v2/api-docs/**"
//                ).antMatchers(HttpMethod.OPTIONS)
//                .antMatchers("/**/login")
//                .antMatchers("/**/register")
//                .antMatchers(HttpMethod.GET, "/posting/**")
//                .antMatchers("/category/**");
    }

    //配置如何通过拦截器保护请求
    //TODO 经过拦截器后，请求还会经过过滤器
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问(主要是swagger相关资源)
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.*",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                )
                    .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                    .permitAll()
                .antMatchers("/**/login", "/**/register")
                    .permitAll()
                .antMatchers("/userCenter/**")
                    .authenticated()
                .antMatchers(HttpMethod.GET, "/**")
                    .permitAll()
                .anyRequest()
                    .authenticated();

        http.requiresChannel()  //增加https
                .antMatchers("/**")
                    .requiresSecure();

        http.csrf().disable();
        http.sessionManagement()// 基于token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 禁用缓存（不使用session，故基本用不上缓存）
        http.headers().cacheControl();

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

    //配置authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(wallAdminAuthenticationProvider())
                .authenticationProvider(wallUserAuthenticationProvider());
    }

}
