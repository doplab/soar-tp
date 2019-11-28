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
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/DOPOrderQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class OrderConsumer implements MessageListener {
    
    public OrderConsumer() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(this + " received the order to " + ((TextMessage) message).getText());
        } catch (JMSException ex) {
            System.err.println("Error when trying to receive message: " + ex.getMessage());
        }
        System.out.println("------");
    }
    
}
