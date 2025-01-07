package kmitl.cs.thanapat.koedpiam;

import javax.jms.*;

public class JMSTextMessageAsyncConsumer implements MessageListener {
    ConnectionFactory connectionFactory;
    Connection connection;
    Destination dest;
    Session session;
    MessageConsumer consumer;

    public JMSTextMessageAsyncConsumer(ConnectionFactory connectionFactory, Destination dest,
                                       boolean isTransaction, int clientType) {
        this.connectionFactory = connectionFactory;
        this.dest = dest;
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(isTransaction, clientType);
            consumer = session.createConsumer(dest);
            consumer.setMessageListener(this);
            connection.start();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onMessage(Message message) {
        TextMessage msg = null;
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                System.out.println("Updated!: " + msg.getText());
            } else {
                System.err.println("Message is not a TextMessage");
            }
        } catch (JMSException e) {
            System.err.println("JMSException in onMessage(): " + e.toString());
        } catch (Throwable t) {
            System.err.println("Exception in onMessage():" + t.getMessage());
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
