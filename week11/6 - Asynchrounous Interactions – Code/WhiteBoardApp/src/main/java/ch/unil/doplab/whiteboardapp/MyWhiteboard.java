/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.whiteboardapp;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Benoit Garbinato <benoit.garbinato@unil.ch>
 */
@ServerEndpoint(value = "/whiteboardendpoint", encoders = {FigureEncoder.class}, decoders = {FigureDecoder.class})
public class MyWhiteboard {

  private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

  @OnMessage
  public void broadcastFigure(Figure figure, Session session) throws IOException, EncodeException {
    System.out.println("broadcastFigure: " + figure);
    for (Session peer : peers) {
      if (!peer.equals(session)) {
        peer.getBasicRemote().sendObject(figure);
      }
    }
  }

  @OnOpen
  public void onOpen(Session peer) {
    peers.add(peer);
  }

  @OnClose
  public void onClose(Session peer) {
    peers.remove(peer);
  }

}
