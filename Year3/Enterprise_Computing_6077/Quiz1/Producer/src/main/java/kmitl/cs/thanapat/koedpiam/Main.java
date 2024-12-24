package kmitl.cs.thanapat.koedpiam;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JMSTextMessageProducer scoreProducer = getScoreProducer();
        Scanner inp = new Scanner(System.in);
        String scoreStr = null;
        while(true) {
            System.out.print("Enter Live Score ");
            scoreStr = inp.nextLine();
            if (!scoreStr.isEmpty()) {
                scoreProducer.sendTextMessage(scoreStr);
            }
            else {
                break;
            }
        }
        scoreProducer.close();
    }
    private static JMSTextMessageProducer getScoreProducer() {
        InitialContext initialContext;
        ConnectionFactory connectionFactory;
        Topic topic;
        try {
            initialContext = new InitialContext();
            connectionFactory = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
            topic = (Topic) initialContext.lookup("liveScoreTopic");
        }  catch (NamingException e) {
            throw new RuntimeException(e);
        }
        JMSTextMessageProducer scoreProducer;
        scoreProducer = new JMSTextMessageProducer(connectionFactory,topic,
                false, Session.AUTO_ACKNOWLEDGE);
        return scoreProducer;
    }
}