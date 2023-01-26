package zerbini.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

    public static void main(String[] args) {

        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        try {
            Connection connection = factory.createConnection();

            // Establish the connection (required for Consumer)
            connection.start();

            // Options of createSession: transacted (boolean) and acknowledgeMode
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create queue if it does not exist
            Destination destination = session.createQueue("demo");

            MessageConsumer consumer = session.createConsumer(destination);
            // Consumer is in listening mode
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
