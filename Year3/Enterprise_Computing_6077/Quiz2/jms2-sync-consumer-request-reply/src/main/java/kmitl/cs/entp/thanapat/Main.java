package kmitl.cs.entp.thanapat;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InitialContext initialContext;
        Queue requestQueue;
        try {
            initialContext = new InitialContext();
            requestQueue = (Queue) initialContext.lookup("RequestQueue");

        }  catch (NamingException e) {
            throw new RuntimeException(e);
        }

        try (ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             JMSContext jmsContext = connectionFactory.createContext()) {

            JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
            JMSProducer replyProducer = jmsContext.createProducer();
            TextListener listener = new TextListener(jmsContext);
            consumer.setMessageListener(listener);
            String ch;
            Scanner inp = new Scanner(System.in);
            while(true) {
                System.out.println("Press q to quit ");
                ch = inp.nextLine();
                if (ch.equals("q")) {
                    break;
                }
            }
        } //catch (JMSException e) {
           // throw new RuntimeException(e);
        //}
    }
}