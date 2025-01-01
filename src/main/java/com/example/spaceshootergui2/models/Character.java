package com.example.spaceshootergui2.models;

import com.example.spaceshootergui2.audio.SoundPlayer;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;

public abstract class Character {
    protected double x;
    protected  double y;
    protected  int health;
    protected  double speed;
    protected boolean destroy;
    protected String imagePath;
    protected boolean hit;
    protected int maxHealth;
    protected int characterWidth = 30;
    protected int characterHeight = 30;
    private boolean explosionStarted = false;


    public Character(double x, double y, int health, double speed, String imagePath) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.speed = speed;
        this.imagePath = imagePath;
        this.maxHealth = health;
    }


    protected void takeDamage() {
        setHit(true);
        health--;

        if(health<1){
            destroy = true;
            SoundPlayer.playSound("/audio/explosion.wav");
        }
    }

    public void moveRight() {
        if(x < GameModel.GAME_WIDTH) {
            x+=speed;
        }
    }

    public void moveLeft() {
        if(x > 0) {
            x-=speed;
        }
    }

    public boolean isExplosionStarted() {
        return explosionStarted;
    }

    public void setExplosionStarted(boolean explosionStarted) {
        this.explosionStarted = explosionStarted;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getImagePath() { return imagePath; }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() { return maxHealth; }

    public int getCharacterWidth() { return characterWidth; }

    public int getCharacterHeight() { return characterHeight; }

    public Bounds getBounds() {
        return new BoundingBox(x, y, characterWidth, characterHeight);
    }

    public boolean isDestroy() {
        return destroy;
    }

    public boolean isHit() {
        return hit;
    }
    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
