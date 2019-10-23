package com.freeLearn.wall.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan(basePackageClasses = {DataConfig.class})
@MapperScan({"com.freeLearn.wall.mapper", "com.freeLearn.wall.dao"})  //mybatis自动创建mapper Bean
@PropertySource("classpath:mybatis-config.properties")
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Value("${mybatis.resources}")
    private String resourceesPath;

    //TODO 事务支持

    @Bean
    SqlSessionFactory sqlSessionFactory() throws Exception {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean factoryBean =
                new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //设置映射文件
        factoryBean.setMapperLocations(resourcePatternResolver.getResources(resourceesPath));
        //别名，让*Mpper.xml实体类映射可以不加上具体包名
        factoryBean.setTypeAliasesPackage("com.freeLearn.wall");
        return factoryBean.getObject();
    }
}
