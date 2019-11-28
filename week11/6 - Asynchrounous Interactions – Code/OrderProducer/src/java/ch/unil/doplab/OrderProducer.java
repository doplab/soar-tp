/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSProducer;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author garbi
 */
public class OrderProducer {

    @Resource(mappedName = "jms/DOPConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/DOPOrderQueue")
    private static Queue queue;

    public static void main(String[] args) throws IOException {
        JMSContext context = connectionFactory.createContext();
        JMSProducer producer = context.createProducer();

        boolean moreOrders = true;
        while (moreOrders) {

            String order = askForOrder(3);
            if (order != null) {
                System.out.println("Sending order to " + order);
                producer.send(queue, order);
                if (order.toLowerCase().contains("quit")) {
                    moreOrders = false;
                }
            } else {
                moreOrders = false;
            }
        }
        System.out.println("Bye bye!");
    }
    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    private static String askForOrder(int attempts) throws IOException {
        String actualOrder = null;
        do {
            System.out.println("------");
            System.out.println("Format of an order is {buy|sell} [0-1]+ [A-Z]+");
            System.out.print("Enter your order: ");
            String order = keyboard.readLine();

            if (order.equals("quit")) {
                return order;
            }

            StringTokenizer st = new StringTokenizer(order);

            if (st.countTokens() != 3) {
                System.out.println("Wrong order format.");
                attempts--;
                continue;
            }

            String cmd = st.nextToken().toLowerCase();
            if (!cmd.equals("buy") && !cmd.equals("sell")) {
                System.out.println("Wrong order format.");
                attempts--;
                continue;
            }

            try {
                new Integer(st.nextToken());
            } catch (NumberFormatException e) {
                System.out.println("Wrong order format.");
                attempts--;
                continue;
            }

            actualOrder = order;
            break;
        } while (attempts > 0);

        return actualOrder;
    }

}
