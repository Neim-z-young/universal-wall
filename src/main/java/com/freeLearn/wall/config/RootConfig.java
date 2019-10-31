package com.freeLearn.wall.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ComponentScan(basePackages = {"com.freeLearn.wall"},
    excludeFilters = {
        @ComponentScan.Filter(type=FilterType.ANNOTATION, value = {EnableWebMvc.class})
    })
@PropertySource({"classpath:platform.properties", "classpath:application.properties"})
public class RootConfig {
    /**
     * 解析占位符 ${}
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
