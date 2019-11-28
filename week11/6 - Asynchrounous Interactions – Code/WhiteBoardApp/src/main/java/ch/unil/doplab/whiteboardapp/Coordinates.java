/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.whiteboardapp;

/**
 *
 * @author Benoit Garbinato <benoit.garbinato@unil.ch>
 */
public class Coordinates {

  private float x;
  private float y;

  public Coordinates() {
  }

  public Coordinates(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return y;
  }

  public void setY(float y) {
    this.y = y;
  }
}
