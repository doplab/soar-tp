package ch.unil.doplab.jms.sender;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSProducer;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class JMSSender {

    @Resource(mappedName = "jms/MyJMSExerciseConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/MyJMSExerciseQueue")
    private static Queue queue;

    public static void main(String[] args) {
        JMSContext jmsContext = connectionFactory.createContext();
        JMSProducer jmsProducer = jmsContext.createProducer();
        String message = "Hello JMS!";
        System.out.println("Sending message to JMS");
        jmsProducer.send(queue, message);
        System.out.println("Message sent!");
    }

}
