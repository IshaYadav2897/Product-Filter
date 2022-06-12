package com.flipkart.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.flipkart")
public class SpringJdbcConfig {

    @Bean
    public DataSource mysqlDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://DESKTOP-9UTK6C9\\\\MSSQLSERVER;databaseName=Flipkart;portNumber=1433;encrypt=false");
        dataSource.setUsername("sa");
        dataSource.setPassword("root");

        return dataSource;
    }

}