package zerbini;

import java.util.Iterator;
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
import org.json.JSONObject;
import org.w3c.dom.Text;

public class JsonConsumer {

    public static void main(String[] args) {

        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        try {
            Connection connection = factory.createConnection();

            // Establish the connection (required for Consumer)
            connection.start();

            // Options of createSession: transacted (boolean) and acknowledgeMode
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create queue if it does not exist
            Destination destination = session.createQueue("JSON-queue");

            MessageConsumer consumer = session.createConsumer(destination);
            // Consumer is in listening mode
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        String jsonString = textMessage.getText();
                        JSONObject json = new JSONObject(jsonString);
                        Iterator<String> keys = json.keys();
                        while(keys.hasNext()) {
                            String key = keys.next();
                            System.out.println(key + ": " + json.get(key));
                        }
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
