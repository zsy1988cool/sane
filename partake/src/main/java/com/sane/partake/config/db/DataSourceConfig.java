package com.sane.partake.config.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@PropertySource(value = {"classpath:env/dev/config.properties"})
@Configuration
public class DataSourceConfig {

    @Value("${datasource.driver}")
    String dsDriver;

    @Value("${datasource.url}")
    String dsUrl;

    @Value("${datasource.username}")
    String userName;

    @Value("${datasource.password}")
    String passWord;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        //driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        driverManagerDataSource.setDriverClassName(dsDriver);
        //driverManagerDataSource.setUrl("jdbc:oracle:thin:@192.168.1.41:1521:zoemdb");
        driverManagerDataSource.setUrl(dsUrl);
        driverManagerDataSource.setUsername(userName);
        driverManagerDataSource.setPassword(passWord);

        return driverManagerDataSource;
    }
}
