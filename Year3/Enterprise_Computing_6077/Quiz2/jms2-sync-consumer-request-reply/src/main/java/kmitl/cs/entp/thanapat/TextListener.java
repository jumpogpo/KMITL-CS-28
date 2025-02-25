package kmitl.cs.entp.thanapat;

import javax.jms.*;

public class TextListener implements MessageListener {
    private final JMSContext jmsContext;

    public TextListener(JMSContext jmsContext) {
        this.jmsContext = jmsContext;
    }

    @Override
    public void onMessage(Message message) {
        JMSProducer replyProducer = jmsContext.createProducer();

        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage objMessage = (ObjectMessage) message;
                Student student = (Student) objMessage.getObject();

                boolean isQualified = student.getGpa() >= 3.5;

                MapMessage response = jmsContext.createMapMessage();
                response.setBoolean("qualified", isQualified);
                response.setJMSCorrelationID(message.getJMSCorrelationID());

                replyProducer.send(message.getJMSReplyTo(), response);

                System.out.println("sending message " + isQualified);

            } else {
                System.err.println("Message is not an ObjectMessage");
            }
        } catch (JMSException e) {
            System.err.println("JMSException in onMessage(): " + e.getMessage());
        }
    }
}
