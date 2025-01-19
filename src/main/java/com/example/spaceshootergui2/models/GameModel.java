package com.example.spaceshootergui2.models;

import com.example.spaceshootergui2.audio.SoundPlayer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameModel {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    private Player player;
    private List<Alien> aliens;
    private List<Bullet> bullets;

    private Level level;
    private List<Attack> attacks;
    private Attack currentAttack;
    private int currentLevelNumber;
    private int currentAttackIndex;
    private final int numOfLevels = 3;
    private int score;

    private boolean pasue = false;
    private boolean isPausedLevel;
    private boolean isPausedAttack;
    private boolean displayNextLevel;
    private boolean displayNextAttack;
    private boolean endGameSound = false;
    private LocalDateTime gameDate;
    private long lastPauseTime = 0;

    public GameModel() {}

    public void initGameModel() {
        this.player = new Player(GAME_WIDTH / 2, GAME_HEIGHT - 100, 10, 20, "player.png");
        this.aliens = new ArrayList<>();
        this.bullets = new ArrayList<>();
        this.score = 0;

        this.currentLevelNumber = 1;
        this.attacks = new ArrayList<>();
        this.currentAttackIndex = 0;
        this.isPausedLevel = true;
        this.isPausedAttack = false;
        this.displayNextLevel = false;
        this.displayNextAttack = false;
        this.pasue = false;
        this.endGameSound = true;
        this.lastPauseTime = 0;

        this.gameDate = LocalDateTime.now();
    }


    public void updateGameState() {
        if (pasue) return;

        if (isWin() || isGameOver()) {
            displayEndSound();
            bullets.clear();
            aliens.clear();
            return;
        }

        if (isPausedAttack || isPausedLevel) {
            startPause();

            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastPauseTime;

            if (elapsedTime >= 1000 && elapsedTime < 3000) {
                if (isPausedLevel) displayNextLevel = true;
                if (isPausedAttack) displayNextAttack = true;
            } else if (elapsedTime >= 3000) {
                if (isPausedLevel) displayNextLevel = false;
                if (isPausedAttack) displayNextAttack = false;
            }

            int PAUSE_DURATION = 4000;
            if (elapsedTime >= PAUSE_DURATION) {
                if (isPausedLevel) {
                    updateLevel();
                    isPausedLevel = false;
                }
                if (isPausedAttack) {
                    initAttack();
                    isPausedAttack = false;
                }
                lastPauseTime = 0;
            }

            bullets.clear();
            return;
        }
        lastPauseTime = 0;

        Iterator<Bullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            bullet.move();

            if (bullet.outOfBounds()) {
                bulletIterator.remove();
                continue;
            }

            if (bullet.getBounds().intersects(player.getBounds()) && bullet.getDirection() == -1) {

                hit(player);
                bulletIterator.remove();
            }
        }

        Iterator<Alien> alienIterator = aliens.iterator();
        while (alienIterator.hasNext()) {
            Alien alien = alienIterator.next();

            if(!alien.isDestroy()) {
                alien.move(alien.getMovingType());

                if (alien.canShoot()) {
                    shoot(alien.getX(), alien.getY() + 1, -1);
                }
            }

            Iterator<Bullet> alienBulletIterator = bullets.iterator();
            while (alienBulletIterator.hasNext()) {
                Bullet bullet = alienBulletIterator.next();
                if (bullet.getBounds().intersects(alien.getBounds()) && bullet.getDirection() == 1) {

                    hit(alien);
                    alienBulletIterator.remove();
                    break;
                }
            }
        }
        if (!isWin()) {
            updateAttack();
        }
    }

    public void removeAlien(Alien alien) {
        score += alien.getMaxHealth() * 10;
        SoundPlayer.playSound("/audio/explosion.wav");
        aliens.remove(alien);
        currentAttack.getAliens().remove(alien);
    }

    private void displayEndSound() {
        if(endGameSound){
            if(isWin()){
                SoundPlayer.playSound("/audio/win.wav");
            }else{
                SoundPlayer.playSound("/audio/explosion.wav");
                SoundPlayer.playSound("/audio/gameover.wav");
            }
            endGameSound = false;
        }
    }

    public void updateLevel() {
        level = new Level(currentLevelNumber);
        initAttack();
    }

    public void initAttack() {
        level.nextAttack();
        attacks = level.getAttacks();

        if (attacks.isEmpty()) {
            return;
        }

        currentAttack = attacks.get(currentAttackIndex);
        currentAttack.spawnAliens();

        aliens.clear();
        aliens.addAll(currentAttack.getAliens());
    }

    public void updateAttack() {
        if (currentAttack.isAttackComplete()) {
            attacks.remove(currentAttack);

            if (level.isLevelComplete()) {
                currentLevelNumber++;

                isPausedLevel = true;

                SoundPlayer.playSound("/audio/newlevel.wav");

            } else {
                isPausedAttack = true;
            }
        }
    }

    public void movePlayerLeft() {
        if (!pasue && !isGameOver() && !isWin()) {
            player.moveLeft();
        }
    }

    public void movePlayerRight() {
        if (!pasue && !isGameOver() && !isWin()) {
            player.moveRight();
        }
    }

    public void shoot(double x, double y, int direction) {
        if(!isWin() && !player.isGameOver() && !isPausedAttack && !isPausedLevel) {
            if(direction == 1){
                SoundPlayer.playSound("/audio/shoot.wav");
            }
            else {
                SoundPlayer.playSound("/audio/alienshoot2.wav");
            }
            bullets.add(new Bullet(x, y, direction));
        }
    }

    public void hit(Character character){
        character.takeDamage();
        SoundPlayer.playSound("/audio/hit.wav");
    }

    public Player getPlayer() {
        return player;
    }


    public List<Alien> getAliens() {
        return aliens;
    }


    public List<Bullet> getBullets() {
        return bullets;
    }


    public int getCurrentLevelNumber() {
        return currentLevelNumber;
    }

    public boolean isWin() {
        if (currentLevelNumber == numOfLevels+1 && level.isLevelComplete()) {
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public boolean isDisplayNextLevel() {
        return displayNextLevel;
    }

    public boolean isDisplayNextAttack() {
        return displayNextAttack;
    }

    public boolean isGameOver() {
        return player.isGameOver();
    }

    public void pauseGame() {
        pasue = true;
    }

    public void restartPauseGame() {
        pasue = false;
    }

    public boolean isPasue() {
        return pasue;
    }

    public LocalDateTime getGameDate() {
        return gameDate;
    }

    public void gameOver() {
        player.setGameOver(true);
    }

    private void startPause() {
        if (lastPauseTime == 0) {
            lastPauseTime = System.currentTimeMillis();
        }
    }

}