package ch.unil.doplab.tcpsocketexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Benoît Garbinato
 */
public class DictionaryClient {

    public static void main(String[] args) {
        Socket mySession = null;
        PrintWriter out = null;
        BufferedReader in = null;
        BufferedReader stdIn = null;
        try {
            mySession = new Socket("localhost", 4444);
            out = new PrintWriter(mySession.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(mySession.getInputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer, fromUser;

            System.out.println("Go on, ask the dictionary server!");
            while (!(fromUser = stdIn.readLine()).equals("quit")) {
                out.println(fromUser);
                fromServer = in.readLine();
                System.out.println("-> " + fromServer);
            }
            out.close();
            in.close();
            stdIn.close();
            mySession.close();
        } catch (UnknownHostException e) {
            System.err.println("Host Unknown: " + args[0]);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No connection to: " + args[0]);
            System.exit(1);
        }
    }
}
