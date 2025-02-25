package kmitl.cs.entp.thanapat.mdbdemo.ejb;

import java.util.logging.Logger;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: ConsumerMDB
 */
@MessageDriven(
		activationConfig = {  
				@ActivationConfigProperty(
						propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
				@ActivationConfigProperty(
						propertyName = "destination", propertyValue = "jms/MDBQueue")		
		}, 
		messageListenerInterface = MessageListener.class)
public class ConsumerMDB implements MessageListener {
	private static Logger LOGGER = Logger.getLogger(ConsumerMDB.class.toString());
    /**
     * Default constructor. 
     */
    public ConsumerMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        if (message instanceof TextMessage) {
        	String text;
			try {
				text = ((TextMessage)message).getText();
				LOGGER.info("Received message: " + text);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

}
