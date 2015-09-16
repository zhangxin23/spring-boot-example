package org.sandbox.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.sandbox.orm.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: zhangxin
 * Date:   15-9-16
 */
@Configuration
public class DaoConfig {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Bean
    public PersonDao personDao() {
        PersonDao personDao = new PersonDao();
        personDao.setSqlSessionFactory(sqlSessionFactory);
        return personDao;
    }
}
