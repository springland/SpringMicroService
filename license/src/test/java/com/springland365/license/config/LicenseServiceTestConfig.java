package com.springland365.license.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("test")
public class LicenseServiceTestConfig {
    @Value("${jdbc.driverClassName}")
    String jdbcDriverClassName ;

    @Value("${jdbc.url}")
    String jdbcUrl ;

    @Value("${jdbc.username}")
    String jdbcUserName ;

    @Value("${jdbc.password}")
    String jdbcPassword ;
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(this.jdbcDriverClassName);
        dataSourceBuilder.url(this.jdbcUrl);
        dataSourceBuilder.username(this.jdbcUserName);
        dataSourceBuilder.password(this.jdbcPassword);
        return dataSourceBuilder.build();
    }
}
