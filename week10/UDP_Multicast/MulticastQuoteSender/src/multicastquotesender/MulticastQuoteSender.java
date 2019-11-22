/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastquotesender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

/**
 *
 * @author garbi
 */
public class MulticastQuoteSender {

    public static void main(String[] args) throws Exception {
        MulticastSocket socket = null;
        BufferedReader in = null;
        socket = new MulticastSocket();
        InetSocketAddress group = new InetSocketAddress(InetAddress.getByName("228.0.0.4"), 9000);
        NetworkInterface networkInterface = NetworkInterface.getByName("en0");
        socket.setTimeToLive(1);
        in = new BufferedReader(new FileReader("one-liners.txt"));
        String quote = null;
        boolean moreQuotes = true;

        while (moreQuotes) {
            Thread.currentThread().sleep(2000);
            byte[] buf = new byte[256];
            quote = in.readLine();
            if (quote == null) {
                moreQuotes = false;
                buf = ("No more, bye!").getBytes();
            } else {
                buf = quote.getBytes();
            }
            System.out.println("About to multicast: " + new String(buf));
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group);
            socket.send(packet);
        }
        socket.close();
    }
}
