package com.sane.partake.config.db;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

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

        driverManagerDataSource.setDriverClassName(dsDriver);
        driverManagerDataSource.setUrl(dsUrl);
        driverManagerDataSource.setUsername(userName);
        driverManagerDataSource.setPassword(passWord);

        return driverManagerDataSource;
    }

    // @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        // 设置数据源
        localSessionFactoryBean.setDataSource(dataSource);

        // 设置hibernate属性
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("dialect", "org.hibernate.dialect.Oracle10gDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);

        // 设置映射文件
        localSessionFactoryBean.setMappingResources(new String[]{"com/sane/partake/intellisense/intellisense.hdb.xml"});

        return localSessionFactoryBean;
    }

    //@Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.ORACLE);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");

        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb =
                new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setMappingResources(new String[]{"com/sane/partake/user/user.hdb.xml", "com/sane/partake/intellisense/intellisense.hdb.xml"});

        return emfb;
    }
}
