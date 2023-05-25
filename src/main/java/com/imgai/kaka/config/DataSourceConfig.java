package com.imgai.kaka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().driverClassName("org.mariadb.jdbc.Driver")
                .url("jdbc:mariadb://app-db-1a.ct4jmgb2iux6.ap-northeast-1.rds.amazonaws.com:3306/draw?characterEncoding=UTF-8")
                .build();
    }

    @Bean
    @ConfigurationProperties("spring.second-datasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().driverClassName("org.mariadb.jdbc.Driver")
                .url("jdbc:mariadb://app-db-1c.ct4jmgb2iux6.ap-northeast-1.rds.amazonaws.com:3306/draw?characterEncoding=UTF-8")
                .build();
    }
}
