package com.immoc.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
//配置mapper扫描文件
@MapperScan("com.immoc.demo.dao")
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private  String jdbcDriver ;
    @Value("${jdbc.url}")
    private  String jdbcUrl ;
    @Value("${jdbc.username}")
    private  String jdbcUserName ;
    @Value("${jdbc.password}")
    private  String jdbcPassWord ;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {

        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUserName);
        dataSource.setPassword(jdbcPassWord);
        return dataSource;
    }
}
