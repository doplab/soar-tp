/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.dop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;

/**
 *
 * @author garbi
 */
public class NewsPublisher {

    @Resource(mappedName = "jms/DOPConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/DOPNewsTopic")
    private static Topic topic;

    public static void main(String[] args) throws IOException, InterruptedException {
        JMSContext context = connectionFactory.createContext();
        JMSProducer producer = context.createProducer();
        int numberOfNews;

        do {
            numberOfNews = askForNumberOfNews(3);

            for (int i = 0; i < numberOfNews; i++) {
                String news = getNextNews();
                System.out.println("Sending news: " + news);
                producer.send(topic, news);
                Thread.sleep(2000);
            }
        } while (numberOfNews > 0);
        
        System.out.println("No more news to send. Bye bye!");
        producer.send(topic, "quit");
    }

    private static String[] companies = {
        "Amazon (AMZN)",
        "Apple (AAPL)",
        "Dell (DELL)",
        "Facebook (FB)",
        "Google (GOOGL)",
        "HP (HPQ)",
        "IBM (IBM)",
        "Intel (INTC)",
        "Microsoft (MSFT)",
        "Oracle (ORCL)",
        "Samsung (KRW)",
        "Spotify (SPOT)",
        "Xerox (XRX)",
        "Yahoo (YHOO)"};

    private static Random random = new Random();
    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    private static String getNextNews() {
        String company = companies[random.nextInt(companies.length)];
        String trend = random.nextBoolean() ? "➚" : "➘";

        float delta = 0.0f;
        do {
            delta = random.nextFloat() * 2;
        } while (delta == 0.0f);

        return company + " " + trend + " " + String.format("%.2f", delta) + "%";
    }

    private static int askForNumberOfNews(int attempts) throws IOException {
        int numberOfNews = 0;
        do {
            System.out.println("------");
            System.out.print("A burst of how many news do you want to publish? ");

            try {
                numberOfNews = new Integer(keyboard.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong format! Please enter an integer number. ");
                attempts--;
                continue;
            }
            break;
        } while (attempts > 0);

        return numberOfNews;
    }
}
