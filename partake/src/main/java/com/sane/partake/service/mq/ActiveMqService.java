package com.sane.partake.service.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.List;

@Service
public class ActiveMqService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ActiveMQQueue activeMQQueue;
    //ConnectionFactory connectionFactory;

    public void sendMessage(String message)
    {
        jmsTemplate.send(activeMQQueue, session -> {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(message);
            return textMessage;
        });
    }

    public List<String> receiveMessage() throws JMSException
    {
        TextMessage textMessage = (TextMessage)jmsTemplate.receiveAndConvert(activeMQQueue);
        if(textMessage != null) {
            String txt = textMessage.getText();
            int i = 0;
            i++;
        }
        return null;
    }
}
