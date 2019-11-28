/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.whiteboardapp;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author Benoit Garbinato <benoit.garbinato@unil.ch>
 */
public class Figure {
  private JsonObject json;

  public Figure(JsonObject json) {
    this.json = json;
  }

  public JsonObject getJson() {
    return json;
  }

  public void setJson(JsonObject json) {
    this.json = json;
  }


  @Override
  public String toString() {
    StringWriter writer = new StringWriter();
    Json.createWriter(writer).write(json);
    return writer.toString();
  }

}
