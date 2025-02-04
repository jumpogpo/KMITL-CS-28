package kmitl.cs.entp.thanapat;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InitialContext initialContext;
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Queue requestQueue;
        Session session;
        MessageConsumer consumer;
        TextListener listener;

        try {
            initialContext = new InitialContext();
            connectionFactory = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
            requestQueue = (Queue) initialContext.lookup("RequestQueue");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            consumer = session.createConsumer(requestQueue);
            listener = new TextListener(session);
            consumer.setMessageListener(listener);

            connection.start();
            System.out.println("Consumer is listening...");

            Scanner inp = new Scanner(System.in);
            while (true) {
                System.out.print("Press q to quit: ");
                if (inp.nextLine().equals("q")) {
                    break;
                }
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (JMSException ignored) {}
        }
    }
}
