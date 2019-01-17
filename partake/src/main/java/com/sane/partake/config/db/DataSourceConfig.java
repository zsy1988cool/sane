package com.sane.partake.config.db;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

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

    @Bean("sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        // 设置数据源
        localSessionFactoryBean.setDataSource(dataSource());

        // 设置hibernate属性
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("dialect", "org.hibernate.dialect.Oracle10gDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);

        // 设置映射文件
        localSessionFactoryBean.setMappingResources(new String[]{ "com/sane/partake/intellisense/Thesaurus.hbm.xml"});

        return localSessionFactoryBean;
    }
}
