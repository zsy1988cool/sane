package com.sane.partake.config.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        //driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        driverManagerDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        //driverManagerDataSource.setUrl("jdbc:oracle:thin:@192.168.1.41:1521:zoemdb");
        driverManagerDataSource.setUrl("jdbc:oracle:thin:@//192.168.1.41:1521/zoemdb");
        driverManagerDataSource.setUsername("zoeconnect");
        driverManagerDataSource.setPassword("zoe$2017cnt");

        return driverManagerDataSource;
    }
}
