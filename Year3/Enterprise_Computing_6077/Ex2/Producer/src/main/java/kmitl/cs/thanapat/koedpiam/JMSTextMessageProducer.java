package kmitl.cs.thanapat.koedpiam;

import javax.jms.*;

public class JMSTextMessageProducer {
    ConnectionFactory connectionFactory;
    Connection connection = null;
    Destination dest;
    Session session;
    MessageProducer producer;

    public JMSTextMessageProducer(ConnectionFactory connectionFactory, Destination dest,
                                  boolean isTransaction, int clientType) {
        this.connectionFactory = connectionFactory;
        this.dest = dest;
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(isTransaction, clientType);
            producer = session.createProducer(dest);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
    public void sendTextMessage(String message) {
         try {
            TextMessage tm = session.createTextMessage(message);
            producer.send(tm);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
    public void close() {
        try {
            session.close();
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
