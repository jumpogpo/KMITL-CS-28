package kmitl.cs.entp.thanapat;

import javax.jms.*;

public class TextListener implements MessageListener {
    private final MessageProducer replyProducer;
    private final Session session;

    public TextListener(Session session) {
        this.session = session;
        try {
            replyProducer = session.createProducer(null); // ใช้แบบ non-persistent
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

                // สร้างข้อความตอบกลับ
                TextMessage response = session.createTextMessage("Hello back");
                response.setJMSCorrelationID(message.getJMSMessageID());

                System.out.println("Sending reply: " + response.getText());

                // ส่งไปยัง Queue ที่กำหนดไว้ใน JMSReplyTo
                replyProducer.send(message.getJMSReplyTo(), response);
            } else {
                System.err.println("Received non-text message");
            }
        } catch (JMSException e) {
            System.err.println("JMSException: " + e.getMessage());
        }
    }
}
