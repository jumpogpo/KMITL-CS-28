package kmitl.cs.entp.thanapat;

import javax.jms.*;
import java.util.Map;

public class TextListener implements MessageListener {
    private final Map<String, Student> studentMap;

    public TextListener(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof MapMessage) {
                MapMessage mapMessage = (MapMessage) message;
                boolean isQualified = mapMessage.getBoolean("qualified");
                String correlationID = mapMessage.getJMSCorrelationID();

                Student student = studentMap.get(correlationID);

                if (student != null) {
                    String result = isQualified ? "will get the scholarship" : "will not get the scholarship";
                    System.out.println(correlationID + " " + student.getName() + " " + result);
                } else {
                    System.out.println("Unknown Student ID: " + correlationID);
                }
            } else {
                System.err.println("Message is not a MapMessage");
            }
        } catch (JMSException e) {
            System.err.println("JMSException in onMessage(): " + e.getMessage());
        }
    }
}
