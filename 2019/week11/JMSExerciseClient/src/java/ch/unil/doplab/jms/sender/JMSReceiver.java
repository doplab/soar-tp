package ch.unil.doplab.jms.sender;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author Melike Geçer
 */
public class JMSReceiver {

    @Resource(mappedName = "jms/MyJMSExerciseConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/MyJMSExerciseQueue")
    private static Queue queue;

    public static void main(String[] args) {
        JMSContext jmsContext = connectionFactory.createContext();
        JMSConsumer jmsConsumer = jmsContext.createConsumer(queue);
        System.out.println("Receiving message from JMS");
        String message = jmsConsumer.receiveBody(String.class);
        System.out.println("Message received : " + message);
    }
}
