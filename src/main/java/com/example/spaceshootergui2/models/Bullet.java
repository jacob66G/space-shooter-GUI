package com.example.spaceshootergui2.models;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;

public class Bullet {
    private double x;
    private double y;
    private final double direction;
    private final int bulletWidth =  12;
    private final int bulletHeight = 30;

    public Bullet(double x, double y, double direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move() {
        double speed = 5;
        y -= direction * speed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean outOfBounds() {
        if(y < 0 || y >= GameModel.GAME_HEIGHT){
            return true;
        }
        return false;
    }

    public Bounds getBounds() {
        return new BoundingBox(x, y, bulletWidth , bulletHeight);
    }

    public double getDirection() {
        return direction;
    }

    public int getBulletWidth() {
        return bulletWidth;
    }

    public int getBulletHeight() {
        return bulletHeight;
    }
}
