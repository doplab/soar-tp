package ch.unil.doplab.udpmulticastexample;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Benoît Garbinato
 */
public class MulticastQuoteReceiver {

    public static void main(String[] args) throws Exception {
        try (MulticastSocket socket = new MulticastSocket(9000)) {
            InetSocketAddress group = new InetSocketAddress(InetAddress.getByName("228.0.0.4"), 9000);
            NetworkInterface netInterface = NetworkInterface.getByName("en0");
            socket.joinGroup(group, netInterface);
            while (true) {
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                System.out.print("Waiting for the next quote: ");
                socket.receive(packet);
                String received = new String(packet.getData());
                System.out.println(received.trim());
                if (received.contains("bye")) {
                    break;
                }
            }
            socket.leaveGroup(group, netInterface);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
