package kmitl.cs.entp.thanapat;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        InitialContext initialContext;
        Queue queue;
        TextMessage message = null;

        try {
            initialContext = new InitialContext();
            queue = (Queue) initialContext.lookup("jms/SimpleJMSQueue");

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        try (ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             JMSContext jmsContext = connectionFactory.createContext()) {

            QueueBrowser browser = jmsContext.createBrowser(queue);
            Enumeration msgs = browser.getEnumeration();

            if (!msgs.hasMoreElements()) {
                System.out.println("No messages in queue");
            } else {
                while (msgs.hasMoreElements()) {
                    Message tempMsg = (Message) msgs.nextElement();
                    if (tempMsg instanceof TextMessage) {
                        message = (TextMessage) tempMsg;
                        System.out.println("Reading message: " + message.getText());
                    } else {
                        System.out.println("Message is not a text message");
                    }
                }
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
