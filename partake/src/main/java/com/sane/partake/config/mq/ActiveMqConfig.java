package com.sane.partake.config.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.jms.core.JmsTemplate;

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
    ActiveMQConnectionFactory targetConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerURL);
        return activeMQConnectionFactory;
    }

    /*@Bean
    SingleConnectionFactory connectionFactory(ActiveMQConnectionFactory targetConnectionFactory) {
        return new SingleConnectionFactory(targetConnectionFactory);
    }*/

    @Bean
    ActiveMQQueue activeMQQueue() {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("text-msg");
        return activeMQQueue;
    }

    @Bean
    JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }
}
