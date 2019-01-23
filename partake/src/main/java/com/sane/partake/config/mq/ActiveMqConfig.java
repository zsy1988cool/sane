package com.sane.partake.config.mq;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.jms.ConnectionFactory;

@PropertySource(value = {"classpath:env/dev/config.properties"})
@Configuration
public class ActiveMqConfig {

    @Value("${activeMq.username}")
    private String userName;

    @Value("${activeMq.password}")
    private String password;

    @Value("${activeMq.brokerURL}")
    private String brokerURL;

    @Bean
    ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerURL);
        return activeMQConnectionFactory;
    }
}
