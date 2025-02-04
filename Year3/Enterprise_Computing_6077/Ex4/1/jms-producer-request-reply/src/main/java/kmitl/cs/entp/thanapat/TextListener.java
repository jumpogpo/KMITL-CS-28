package kmitl.cs.entp.thanapat;

import javax.jms.*;

public class TextListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                System.out.println("Received reply: " + msg.getText() +
                        " with CorrelationID: " + msg.getJMSCorrelationID());
            } else {
                System.err.println("Received non-text message");
            }
        } catch (JMSException e) {
            System.err.println("JMSException: " + e.getMessage());
        }
    }
}
