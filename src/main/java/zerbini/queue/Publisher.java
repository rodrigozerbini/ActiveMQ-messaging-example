package zerbini.queue;

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

            // Create queue if it does not exist already
            Destination destination = session.createQueue("demo");

            String[] messages = {
                    "First message",
                    "Second message",
                    "Third message",
                    "Fourth message"
            };

            MessageProducer producer = session.createProducer(destination);

            for (String message : messages) {
                TextMessage textMessage = session.createTextMessage(message);
                // Publish the message to the queue
                producer.send(textMessage);
            }

            System.out.println("Messages published");

            session.close();
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
