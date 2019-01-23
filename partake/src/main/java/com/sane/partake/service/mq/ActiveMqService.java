package com.sane.partake.service.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQMessageConsumer;
import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActiveMqService {

    @Autowired
    ConnectionFactory connectionFactory;

    public void sendMessage(String message) throws JMSException
    {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("text-msg");

        MessageProducer messageProducer = session.createProducer(queue);
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        TextMessage txtMessage = session.createTextMessage(message);
        for(int i = 0; i < 3; i++) {
            messageProducer.send(txtMessage);
        }

        messageProducer.close();
        connection.close();
    }

    public List<String> receiveMessage() throws JMSException
    {
        ActiveMQConnection connection = (ActiveMQConnection)connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("text-msg");

        ActiveMQMessageConsumer messageConsumer = (ActiveMQMessageConsumer)session.createConsumer(queue);
        messageConsumer.start();
        int aa = messageConsumer.getPrefetchNumber();

        /*
        messageConsumer.setMessageListener(message -> {
            TextMessage txtMessage = (TextMessage)message;
            try {
                System.out.println("消息接收" + txtMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }); */

        List<String> messageList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Message message = messageConsumer.receiveNoWait();
            if(message != null) {
                TextMessage txtMessage = (TextMessage)message;
                if(txtMessage != null) {
                    messageList.add(txtMessage.getText());
                }
            }
        }
        messageConsumer.stop();
        messageConsumer.close();
        connection.close();
        session.close();

        return messageList;
    }
}
