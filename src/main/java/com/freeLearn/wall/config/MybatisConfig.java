package com.freeLearn.wall.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@Import(DataConfig.class)
@MapperScan({"com.freeLearn.wall.mapper", "com.freeLearn.wall.dao"})  //mybatis自动创建mapper Bean
@PropertySource("classpath:mybatis-config.properties")
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Value("${mybatis.resources}")
    private String resourcesPath;

    //TODO 事务支持

    @Bean
    SqlSessionFactory sqlSessionFactory() throws Exception {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean factoryBean =
                new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //设置映射文件
        factoryBean.setMapperLocations(resourcePatternResolver.getResources(resourcesPath));
        //别名，让*Mpper.xml实体类映射可以不加上具体包名
        factoryBean.setTypeAliasesPackage("com.freeLearn.wall");
        factoryBean.setPlugins(new Interceptor[]{pageInterceptor()});
        return factoryBean.getObject();
    }

    @Bean
    PageInterceptor pageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "false");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

}
