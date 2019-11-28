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
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 *
 * @author garbi
 */
public class NewsSubscriber implements MessageListener {

    @Resource(mappedName = "jms/DOPConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/DOPNewsTopic")
    private static Topic topic;

    private static boolean stopReceiving = false;

    public static void main(String[] args) throws InterruptedException {
        JMSContext context = connectionFactory.createContext();
        JMSConsumer consumer = context.createConsumer(topic);

        /*
            Asynchronous version - With onMessage() callback
         */
        MessageListener listener = new NewsSubscriber();
        consumer.setMessageListener(listener);
        for (int i = 0; i < 60; i++) {
            Thread.sleep(1000);
            System.out.print(".");
            if (stopReceiving) {
                break;
            }
        }
        System.out.println("\nBye bye!");
    }

    @Override
    public void onMessage(Message message) {
        System.out.println();
        String news = "quit";
        try {
            news = ((TextMessage) message).getText();
            System.out.println("I received the following news: " + news);
        } catch (JMSException ex) {
            System.err.println("Error when trying to receive message: " + ex.getMessage());
        }
        System.out.println("------");
        if (news.toLowerCase().contains("quit")) {
            stopReceiving = true;
        }
    }
}
