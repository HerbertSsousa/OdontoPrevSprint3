package com.example.sinistros.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class OracleConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL")
                .username("RM553227")
                .password("180305")
                .driverClassName("oracle.jdbc.OracleDriver")
                .build();
    }
}
