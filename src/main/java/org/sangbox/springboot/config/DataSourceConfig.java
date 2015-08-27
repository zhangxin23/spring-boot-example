package org.sangbox.springboot.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


/**
 * Created by zhangxin on 15/8/26.
 */

@Configuration
@MapperScan(basePackages = "org.sandbox.springboot.mapper")
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?autoReconnect=true&useCompression=true" +
                    "&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
            dataSource.setUser("root");
            dataSource.setPassword("mysql");
            dataSource.setAcquireIncrement(10);
            dataSource.setIdleConnectionTestPeriod(60);
            dataSource.setMaxPoolSize(100);
            dataSource.setMaxStatements(50);
            dataSource.setMinPoolSize(10);
        } catch (Exception e) {
            dataSource = null;
        }

        return dataSource;
    }

//    @Bean
//    public DataSourceTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean =  new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
//        ClassPathResource resource = new ClassPathResource("mybatis/PersionMapper.xml");
//        sqlSessionFactoryBean.setMapperLocations(new ClassPathResource[]{resource});

        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/PersionMapper.xml"));
        return sqlSessionFactoryBean;
    }
}
