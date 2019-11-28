/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.whiteboardapp;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Benoit Garbinato <benoit.garbinato@unil.ch>
 */
public class FigureDecoder implements Decoder.Text<Figure> {

  @Override
  public Figure decode(String s) throws DecodeException {
    JsonObject jsonObject = Json.createReader(new StringReader(s)).readObject();
    return new Figure(jsonObject);
  }

  @Override
  public boolean willDecode(String s) {
    try {
      Json.createReader(new StringReader(s)).readObject();
      return true;
    } catch (JsonException ex) {
      ex.printStackTrace();
      return false;
    }
  }

  @Override
  public void init(EndpointConfig config) {
    System.out.println("init");
  }

  @Override
  public void destroy() {
    System.out.println("destroy");
  }

}
