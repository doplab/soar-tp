package com.mycompany.soar_chat.server;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Alpha Diallo
 */
@ServerEndpoint("/chatendpoint")
public class chatEndPoint {

    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session peer) throws IOException {
        clients.add(peer);
        System.out.println("New session opened");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        for (Session client : clients) {
            System.out.println(message);
            client.getBasicRemote().sendText(message);
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println("Session closed!");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {

    }

}
