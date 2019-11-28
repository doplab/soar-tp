/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author garbi
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/DOPNewsTopic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/DOPNewsTopic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/DOPNewsTopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class NewsSubscriber implements MessageListener {
    
    public NewsSubscriber() {
    }
    
    @Override
    public void onMessage(Message message) {
                System.out.println();
        try {
            String news = ((TextMessage) message).getText();
            System.out.println(this + " received the following news: " + news);
        } catch (JMSException ex) {
            System.err.println("Error when trying to receive message: " + ex.getMessage());
        }
        System.out.println("------");
    }   
}
