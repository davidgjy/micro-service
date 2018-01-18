package com.genesis.origin.provider.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午1:40 2018/1/17
 * @Modified by:
 */

@Configuration
@MapperScan(basePackages = "com.genesis.origin.provider.mapper")
public class MyBatisConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws Exception {
        Properties props = new Properties();
        props.put("driver", env.getProperty("jdbc.driver"));
        props.put("url", env.getProperty("jdbc.url"));
        props.put("username", env.getProperty("jdbc.username"));
        props.put("password", env.getProperty("jdbc.password"));

        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);
        fb.setTypeAliasesPackage("com.genesis.origin.provider.model");
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));

        return fb.getObject();
    }
}
