package com.nhndooray.edu.springcore2.config;


import com.nhndooray.edu.springcore2.SpringCore2Application;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@EnableJdbcAuditing
@EnableJdbcRepositories(
        basePackageClasses = SpringCore2Application.class,
        jdbcOperationsRef = "userNamedParameterJdbcOperations",
        transactionManagerRef = "memberTransactionManager")
public class DatasourceConfig {

    @Bean
    @ConfigurationProperties("datasource.member")
    public DataSourceProperties memberDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource memberDataSource() {
        return memberDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    public NamedParameterJdbcOperations userNamedParameterJdbcOperations() {
        return new NamedParameterJdbcTemplate(memberDataSource());
    }

    @Bean
    @Primary
    public PlatformTransactionManager memberTransactionManager() {
        return new DataSourceTransactionManager(memberDataSource());
    }

}
