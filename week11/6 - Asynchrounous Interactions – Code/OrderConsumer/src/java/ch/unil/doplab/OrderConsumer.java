/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

public class OrderConsumer { // implements MessageListener {

    @Resource(mappedName = "jms/DOPConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/DOPOrderQueue")
    private static Queue queue;

    private static boolean stopReceiving = false;

    public static void main(String[] args) throws InterruptedException {
        JMSContext context = connectionFactory.createContext();
        JMSConsumer consumer = context.createConsumer(queue);

        System.out.println("I am now ready to receive orders");

        /* 
            Synchronous version - Without onMessage() callback
         */
        while (true) {
            String order = consumer.receiveBody(String.class);
            System.out.println("The order is to " + order);
            if (order.toLowerCase().contains("quit")) {
                break;
            }
        }
        /*
            Asynchronous version - With onMessage() callback
         */
//        MessageListener listener = new OrderConsumer();
//        consumer.setMessageListener(listener);
//        for (int i = 0; i < 60; i++) {
//            Thread.sleep(1000);
//            System.out.print(".");
//            if (stopReceiving) {
//                break;
//            }
//        }
        System.out.println("\nBye bye!");
    }

//    @Override
    public void onMessage(Message message) {
        System.out.println();
        String order = "quit";
        try {
            order = ((TextMessage) message).getText();
            System.out.println("I received the order to " + order);
        } catch (JMSException ex) {
            System.err.println("Error when trying to receive message: " + ex.getMessage());
        }
        System.out.println("------");
        if (order.toLowerCase().contains("quit")) {
            stopReceiving = true;
        }
    }
}
