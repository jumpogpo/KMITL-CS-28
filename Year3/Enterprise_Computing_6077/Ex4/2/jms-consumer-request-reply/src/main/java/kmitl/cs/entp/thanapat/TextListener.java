package kmitl.cs.entp.thanapat;

import javax.jms.*;

public class TextListener implements MessageListener {
    private final MessageProducer replyProducer;
    private final Session session;

    public TextListener(Session session) {
        this.session = session;
        try {
            replyProducer = session.createProducer(null);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                System.out.println("Received: " + msg.getText());

                TextMessage response = session.createTextMessage("Hello back");
                response.setJMSCorrelationID(message.getJMSMessageID());

                System.out.println("Sending reply: " + response.getText());

                Destination replyDestination = message.getJMSReplyTo();
                if (replyDestination != null) {
                    replyProducer.send(replyDestination, response);
                } else {
                    System.err.println("No JMSReplyTo destination found!");
                }
            } else {
                System.err.println("Received non-text message");
            }
        } catch (JMSException e) {
            System.err.println("JMSException: " + e.getMessage());
        }
    }
}
