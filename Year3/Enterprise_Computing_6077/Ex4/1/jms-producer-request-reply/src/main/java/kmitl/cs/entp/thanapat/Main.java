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
        Queue replyQueue;
        Session session;
        MessageProducer producer;
        MessageConsumer responseConsumer;
        TextListener listener;

        try {
            // ค้นหา JNDI
            initialContext = new InitialContext();
            connectionFactory = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
            requestQueue = (Queue) initialContext.lookup("RequestQueue");
            replyQueue = (Queue) initialContext.lookup("ReplyQueue");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        try {
            // สร้าง Connection และ Session
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(requestQueue);

            // ตั้งค่า Consumer เพื่อรับคำตอบ
            listener = new TextListener();
            responseConsumer = session.createConsumer(replyQueue);
            responseConsumer.setMessageListener(listener);

            // สร้างและส่งข้อความ
            TextMessage message = session.createTextMessage("Hello friend");
            message.setJMSReplyTo(replyQueue); // กำหนด Queue สำหรับรับคำตอบ

            connection.start();
            System.out.println("Sending message: " + message.getText());
            producer.send(message);

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
