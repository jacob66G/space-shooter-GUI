package com.example.spaceshootergui2.models;

public class Player extends Character{

    private boolean gameOver;

    public Player(int x, int y, int health, double speed, String imagePath) {
        super(x, y, health, speed, imagePath);
        this.gameOver = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
