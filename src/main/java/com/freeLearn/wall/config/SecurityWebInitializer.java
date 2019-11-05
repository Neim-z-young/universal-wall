package com.freeLearn.wall.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 通过该类，Spring能在容器中注册delegateFilterProxy
 * （就因为这一个类，我花了一个下午都没配置好spring security）
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
}
