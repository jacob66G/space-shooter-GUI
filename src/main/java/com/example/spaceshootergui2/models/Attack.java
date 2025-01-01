package com.example.spaceshootergui2.models;

import java.util.ArrayList;
import java.util.List;

public class Attack {
    private int attackNumber;
    private List<Alien> aliens;
    ;
    private int levelNumber;

    public Attack(int attackNumber, int levelNumber) {
        this.attackNumber = attackNumber;
        this.aliens = new ArrayList<>();
        this.levelNumber = levelNumber;
    }

    public void spawnAliens() {
        int gameWidth = GameModel.GAME_WIDTH;
        int gameHeight = GameModel.GAME_HEIGHT;

        if (levelNumber == 1) {

            if (attackNumber == 1) {
                Alien alien1 = new Alien(gameWidth / 2, gameHeight - 500, 1, 1, 10, "alien1.png", 3200, 1);
                Alien alien2 = new Alien(gameWidth / 2 + 100, gameHeight - 500, 1, 1, 10, "alien1.png", 2000, 1);
                Alien alien3 = new Alien(gameWidth / 2 - 100, gameHeight - 500, 1, 1, 10, "alien1.png", 4700, 1);
                aliens.add(alien1);
                aliens.add(alien2);
                aliens.add(alien3);
            }
            else if (attackNumber == 2) {
                Alien alien1 = new Alien(gameWidth / 2 + 250, gameHeight - 500, 1, 1, 10, "alien1.png", 3400, 6);
                Alien alien2 = new Alien(gameWidth / 2 + 100, gameHeight - 450, 1, 1, 10, "alien2.png", 2600, 4);
                Alien alien3 = new Alien(gameWidth / 2 - 100, gameHeight - 450, 1, 1, 10, "alien2.png", 1000, 4);
                Alien alien4 = new Alien(gameWidth / 2 - 250, gameHeight - 500, 1, 1, 10, "alien1.png", 2300, 6);
                aliens.add(alien1);
                aliens.add(alien2);
                aliens.add(alien3);
                aliens.add(alien4);
            } else {
                Alien alien1 = new Alien(gameWidth / 2 + 200, gameHeight - 400, 1, 1, 10, "alien1.png", 3400, 5);
                Alien alien2 = new Alien(gameWidth / 2 + 100, gameHeight - 500, 1, 1, 10, "alien1.png", 5005, 5);
                Alien alien3 = new Alien(gameWidth / 2 - 100, gameHeight - 400, 1, 1, 10, "alien1.png", 4450, 5);
                Alien alien4 = new Alien(gameWidth / 2 - 200, gameHeight - 500, 1, 1, 10, "alien1.png", 6450, 5);
                aliens.add(alien1);
                aliens.add(alien2);
                aliens.add(alien3);
                aliens.add(alien4);
            }

        }
        else if(levelNumber == 2) {

            if (attackNumber == 1) {
                Alien alien1Raid1 = new Alien(gameWidth / 2 - 250, gameHeight - 500, 2, 1, 10, "alien3.png", 2250, 3);
                Alien alien2Raid1 = new Alien(gameWidth / 2 + 250, gameHeight - 500, 2, 1, 10, "alien3.png", 1300, 3);
                Alien alien3Raid1 = new Alien(gameWidth / 2 - 100, gameHeight - 300, 2, 1, 10, "alien3.png", 2350, 3);
                Alien alien4Raid1 = new Alien(gameWidth / 2 + 100, gameHeight - 300, 2, 1, 10, "alien3.png", 3330, 3);
                aliens.add(alien1Raid1);
                aliens.add(alien2Raid1);
                aliens.add(alien3Raid1);
                aliens.add(alien4Raid1);

            }
            else if (attackNumber == 2) {
                Alien alien1Raid2 = new Alien(gameWidth / 2, gameHeight - 500, 2, 1, 10, "alien3.png", 2380, 4);
                Alien alien2Raid2 = new Alien(gameWidth / 2 + 300, gameHeight - 500, 2, 1, 10, "alien3.png", 3400, 4);
                Alien alien3Raid2 = new Alien(gameWidth / 2 - 300, gameHeight - 500, 2, 1, 10, "alien3.png", 1350, 4);
                Alien alien4Raid2 = new Alien(gameWidth / 2 + 160, gameHeight - 300, 2, 1, 10, "alien2.png", 3390, 6);
                Alien alien5Raid2 = new Alien(gameWidth / 2 - 160, gameHeight - 300, 2, 1, 10, "alien2.png", 1450, 6);
                aliens.add(alien1Raid2);
                aliens.add(alien2Raid2);
                aliens.add(alien3Raid2);
                aliens.add(alien4Raid2);
                aliens.add(alien5Raid2);
            } else {
                Alien alien1 = new Alien(gameWidth / 2 + 300, gameHeight - 400, 2, 1, 10, "alien3.png", 1530, 6);
                Alien alien2 = new Alien(gameWidth / 2 + 240, gameHeight - 300, 2, 1, 10, "alien3.png", 3470, 6);
                Alien alien3 = new Alien(gameWidth / 2 + 100, gameHeight - 500, 2, 1, 10, "alien3.png", 2450, 6);
                Alien alien4 = new Alien(gameWidth / 2 - 100, gameHeight - 500, 2, 1, 10, "alien3.png", 1460, 6);
                Alien alien5 = new Alien(gameWidth / 2 - 140, gameHeight - 300, 2, 1, 10, "alien3.png", 2510, 6);
                Alien alien6 = new Alien(gameWidth / 2 - 300, gameHeight - 400, 2, 1, 10, "alien3.png", 4570, 6);
                aliens.add(alien1);
                aliens.add(alien2);
                aliens.add(alien3);
                aliens.add(alien4);
                aliens.add(alien5);
                aliens.add(alien6);
            }
        }

            else if (levelNumber == 3) {
                if (attackNumber == 1) {
                    Alien alien1Raid1 = new Alien(gameWidth / 2 + 300, gameHeight - 400, 3, 1, 10, "alien4.png", 3250, 6);
                    Alien alien2Raid1 = new Alien(gameWidth / 2 + 200, gameHeight - 500, 3, 1, 10, "alien4.png", 4300, 4);
                    Alien alien3Raid1 = new Alien(gameWidth / 2, gameHeight - 520, 3, 1, 10, "alien5.png", 3350, 5);
                    Alien alien4Raid1 = new Alien(gameWidth / 2 - 200, gameHeight - 500, 3, 1, 10, "alien4.png", 2330, 4);
                    Alien alien5Raid1 = new Alien(gameWidth / 2 - 300, gameHeight - 400, 3, 1, 10, "alien4.png", 4300, 6);
                    aliens.add(alien1Raid1);
                    aliens.add(alien2Raid1);
                    aliens.add(alien3Raid1);
                    aliens.add(alien4Raid1);
                    aliens.add(alien5Raid1);
                }
                else if (attackNumber == 2) {
                    Alien alien1Raid2 = new Alien(gameWidth / 2, gameHeight - 300, 3, 1, 10, "alien4.png", 2300, 1);
                    Alien alien2Raid2 = new Alien(gameWidth / 2 + 220, gameHeight - 300, 3, 1, 10, "alien4.png", 3400, 1);
                    Alien alien3Raid2 = new Alien(gameWidth / 2 - 220, gameHeight - 300, 3, 1, 10, "alien4.png", 4350, 1);
                    Alien alien4Raid2 = new Alien(gameWidth / 2 + 80, gameHeight - 500, 3, 1, 10, "alien5.png", 1350, 3);
                    Alien alien5Raid2 = new Alien(gameWidth / 2 - 80, gameHeight - 500, 3, 1, 10, "alien5.png", 2300, 3);
                    aliens.add(alien1Raid2);
                    aliens.add(alien2Raid2);
                    aliens.add(alien3Raid2);
                    aliens.add(alien4Raid2);
                    aliens.add(alien5Raid2);
                } else {
                    Alien alien1 = new Alien(gameWidth / 2 + 300, gameHeight - 350, 3, 1, 10, "alien5.png", 1430, 6);
                    Alien alien2 = new Alien(gameWidth / 2 + 200, gameHeight - 400, 3, 1, 10, "alien5.png", 4370, 5);
                    Alien alien3 = new Alien(gameWidth / 2 + 100, gameHeight - 500, 3, 1, 10, "alien5.png", 3450, 4);
                    Alien alien4 = new Alien(gameWidth / 2, gameHeight - 300, 5, 1, 10, "alien6.png", 2250, 6);
                    Alien alien5 = new Alien(gameWidth / 2 - 100, gameHeight - 500, 3, 1, 10, "alien5.png", 1360, 4);
                    Alien alien6 = new Alien(gameWidth / 2 - 200, gameHeight - 400, 3, 1, 10, "alien5.png", 4410, 5);
                    Alien alien7 = new Alien(gameWidth / 2 - 300, gameHeight - 350, 3, 1, 10, "alien5.png", 3340, 6);
                    aliens.add(alien1);
                    aliens.add(alien2);
                    aliens.add(alien3);
                    aliens.add(alien4);
                    aliens.add(alien5);
                    aliens.add(alien6);
                    aliens.add(alien7);
                }
            }
    }

    public boolean isAttackComplete() {
        return aliens.isEmpty();
    }

    public List<Alien> getAliens() {
        return aliens;
    }
}
