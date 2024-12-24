package kmitl.cs.thanapat.koedpiam;

import javax.jms.ConnectionFactory;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        JMSTextMessageAsyncConsumer scoreReader = getScoreReader();
        InputStreamReader inputStreamReader;
        char answer = '\0';

        System.out.println(
                "To end program, type Q or q, " + "then <return>");
        inputStreamReader = new InputStreamReader(System.in);

        while (!((answer == 'q') || (answer == 'Q'))) {
            try {
                answer = (char) inputStreamReader.read();
            } catch (IOException e) {
                System.err.println("I/O exception: " + e.toString());
            }
        }
        scoreReader.close();
    }
    private static JMSTextMessageAsyncConsumer getScoreReader() {
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
        JMSTextMessageAsyncConsumer scoreReader;
        scoreReader = new JMSTextMessageAsyncConsumer(connectionFactory,topic,
                false, Session.AUTO_ACKNOWLEDGE);
        return scoreReader;
    }
}