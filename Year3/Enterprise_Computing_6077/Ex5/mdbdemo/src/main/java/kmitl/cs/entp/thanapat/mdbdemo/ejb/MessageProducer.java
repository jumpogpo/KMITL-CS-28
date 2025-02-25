package kmitl.cs.entp.thanapat.mdbdemo.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;
import jakarta.jms.Queue;

/**
 * Session Bean implementation class MessageProducer
 */
@Stateless
@LocalBean
public class MessageProducer {
	@Resource(mappedName="java:jboss/exported/jms/jms/MDBQueue")
    Queue myQueue;
	@Inject
	JMSContext jmsContext;
	
	public void sendMessage(String message) {
		JMSProducer producer = jmsContext.createProducer();
		producer.send(myQueue, message);
	}
}
