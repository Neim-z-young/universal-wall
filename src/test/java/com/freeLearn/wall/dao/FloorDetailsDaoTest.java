package com.freeLearn.wall.dao;

import com.freeLearn.wall.config.MybatisConfig;
import com.freeLearn.wall.domain.FloorDetails;
import com.freeLearn.wall.domain.InsideFloorDetails;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;


public class FloorDetailsDaoTest {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment env = new StandardEnvironment();
        //设置配置环境为"dev"
        env.addActiveProfile("dev");
        context.setEnvironment(env);
        context.register(com.freeLearn.wall.testConfig.TestConfig.class);
        context.register(com.freeLearn.wall.config.MybatisConfig.class);
        context.refresh();

        SqlSessionFactory factory = context.getBean(SqlSessionFactory.class);
        SqlSession session = factory.openSession();
        InsideFloorDetailsDao insideDao = session.getMapper(InsideFloorDetailsDao.class);
        InsideFloorDetails details = insideDao.selectByPrimaryKey(1);
        System.out.println(details);

        FloorDetailsDao dao = session.getMapper(FloorDetailsDao.class);
        PageHelper.startPage(1,2);
        FloorDetails details1 = dao.selectByPrimaryKey(1);
        System.out.println(details1);
        session.close();
    }
}
