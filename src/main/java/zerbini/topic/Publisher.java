package zerbini.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {

    public static void main(String[] args) {

        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create topic if it does not exist already
            Destination destination = session.createTopic("demo-topic");

            MessageProducer producer = session.createProducer(destination);

            TextMessage textMessage = session.createTextMessage("Message for topic");
            // Publish the message to the topic
            producer.send(textMessage);

            System.out.println("Message published to topic");

            session.close();
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
