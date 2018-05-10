package com.immoc.demo.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;

@Configuration
public class SessionFactoryConfiration {

    @Value("${mybatis_config_file}")
    private String mybatis_config_file;
    @Value("${mapper_path}")
    private String mapper_path;
    @Value("${entity_package}")
    private String entity_package;

    @Autowired
    @Qualifier(value = "dataSource")
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactotyBean() throws IOException {

        SqlSessionFactoryBean sqlBean=new SqlSessionFactoryBean();
        sqlBean.setConfigLocation(new ClassPathResource(mybatis_config_file));
        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        String packageScan=PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapper_path;
        sqlBean.setMapperLocations(resolver.getResources(packageScan));
        sqlBean.setDataSource(dataSource);
        sqlBean.setTypeAliasesPackage(entity_package);
        return sqlBean;
    }


}
