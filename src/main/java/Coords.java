/*
 * Copyright (c) 2023
 * author: ac-f
 * email: fantasy1621821@gmail.com
 * website: https://ac-f.io/
 */

public class Coords {
  private int x;
  private int y;
  Coords (int x, int y) {
    this.x = x;
    this.y = y;
  }

  public double getDistance(Coords coords) {
    var diffX = Math.abs(x - coords.getX());
    var diffY = Math.abs(y - coords.getY());
    return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }
}
