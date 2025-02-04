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
        MessageProducer producer;
        TemporaryQueue tempQueue;
        MessageConsumer responseConsumer;

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

            tempQueue = session.createTemporaryQueue();

            producer = session.createProducer(requestQueue);
            responseConsumer = session.createConsumer(tempQueue);

            TextMessage message = session.createTextMessage("Hello friend");
            message.setJMSReplyTo(tempQueue); 

            connection.start();
            System.out.println("Sending message: " + message.getText());
            producer.send(message);

            Message replyMessage = responseConsumer.receive(5000);
            if (replyMessage instanceof TextMessage) {
                TextMessage replyText = (TextMessage) replyMessage;
                System.out.println("Received reply: " + replyText.getText());
            } else {
                System.out.println("No reply received within timeout.");
            }

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
