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
            } else if (attackNumber == 2) {
                Alien alien1 = new Alien(gameWidth / 2 + 250, gameHeight - 500, 1, 1, 10, "alien1.png", 3400, 6);
                Alien alien2 = new Alien(gameWidth / 2 + 100, gameHeight - 450, 1, 1, 10, "alien2.png", 2600, 4);
                Alien alien3 = new Alien(gameWidth / 2 - 100, gameHeight - 450, 1, 1, 10, "alien2.png", 5500, 4);
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
//        else if(levelNumber == 2) {

//            if (attackNumber == 1) {
//                Alien alien1Raid1 = new Alien(gameWidth / 2 - 8, 3, 2, 55, "alien3.png",  225,3);
//                Alien alien2Raid1 = new Alien(gameWidth / 2 + 5, 3, 2, 55, "alien3.png",  330,3);
//                Alien alien3Raid1 = new Alien(gameWidth / 2 - 4, 3 + 3, 2, 55, "alien3.png",  235,3);
//                Alien alien4Raid1 = new Alien(gameWidth / 2 + 8, 3 + 3, 2, 55, "alien3.png",  333,3);
//                aliens.add(alien1Raid1);
//                aliens.add(alien2Raid1);
//                aliens.add(alien3Raid1);
//                aliens.add(alien4Raid1);
//
//            }
//            else if (attackNumber == 2) {
//                Alien alien1Raid2 = new Alien(gameWidth / 2, 3, 2, 55, "alien3.png",  238,4);
//                Alien alien2Raid2 = new Alien(gameWidth / 2 + 12, 3, 2, 55, "alien3.png",  340,4);
//                    Alien alien3Raid2 = new Alien(gameWidth / 2 - 12, 3, 2, 55, "alien3.png",  235,4);
//                Alien alien4Raid2 = new Alien(gameWidth / 2 + 6, 3 + 3, 2, 55, "alien2.png",  339, 6);
//                Alien alien5Raid2 = new Alien(gameWidth / 2 - 6, 3 + 3, 2, 55, "alien2.png",  245, 6);
//                aliens.add(alien1Raid2);
//                aliens.add(alien2Raid2);
//                aliens.add(alien3Raid2);
//                aliens.add(alien4Raid2);
//                aliens.add(alien5Raid2);
//            }
//            else {
//                Alien alien1 = new Alien(gameWidth / 2 + 14, 3, 2, 55, "alien3.png", 253, 6);
//                Alien alien2 = new Alien(gameWidth / 2 + 9, 4, 2, 55, "alien3.png",347, 6);
//                Alien alien3 = new Alien(gameWidth / 2 + 4, 5, 2, 55, "alien3.png", 245, 6);
//                Alien alien4 = new Alien(gameWidth / 2 - 4, 5, 2, 55, "alien3.png", 346, 6);
//                Alien alien5 = new Alien(gameWidth / 2 - 9, 4, 2, 55, "alien3.png", 251, 6);
//                Alien alien6 = new Alien(gameWidth / 2 - 14, 3, 2, 55, "alien3.png"  , 357, 6);
//                aliens.add(alien1);
//                aliens.add(alien2);
//                aliens.add(alien3);
//                aliens.add(alien4);
//                aliens.add(alien5);
//                aliens.add(alien6);
//            }
//
//        }
//        else if(levelNumber == 3) {
//
//            if (attackNumber == 1) {
//                Alien alien1Raid1 = new Alien(gameWidth / 2 + 14, 3, 3, 55, "alien4.png",  325,6);
//                Alien alien2Raid1 = new Alien(gameWidth / 2 + 8, 3 - 1, 3, 55, "alien4.png",  230,4);
//                Alien alien3Raid1 = new Alien(gameWidth / 2, 3 + 3, 3, 55, "alien5.png",  335,5);
//                Alien alien4Raid1 = new Alien(gameWidth / 2 - 8, 3 - 1, 3, 55, "alien4.png",  233,4);
//                Alien alien5Raid1 = new Alien(gameWidth / 2 - 14, 3, 3, 55, "alien4.png",  330, 6);
//                aliens.add(alien1Raid1);
//                aliens.add(alien2Raid1);
//                aliens.add(alien3Raid1);
//                aliens.add(alien4Raid1);
//                aliens.add(alien5Raid1);
//
//            }
//            else if (attackNumber == 2) {
//                Alien alien1Raid2 = new Alien(gameWidth / 2, 3, 3, 55, "alien4.png",  230,1);
//                Alien alien2Raid2 = new Alien(gameWidth / 2 + 12, 3, 3, 55, "alien4.png",  340,1);
//                Alien alien3Raid2 = new Alien(gameWidth / 2 - 12, 3, 3, 55, "alien4.png",  235,1);
//                Alien alien4Raid2 = new Alien(gameWidth / 2 + 4, 3 + 3, 3, 55, "alien5.png",  335, 3);
//                Alien alien5Raid2 = new Alien(gameWidth / 2 - 4, 3 + 3, 3, 55, "alien5.png",  230, 3);
//                aliens.add(alien1Raid2);
//                aliens.add(alien2Raid2);
//                aliens.add(alien3Raid2);
//                aliens.add(alien4Raid2);
//                aliens.add(alien5Raid2);
//            }
//            else {
//                Alien alien1 = new Alien(gameWidth / 2 + 15, 1, 3, 55, "alien5.png", 343, 6);
//                Alien alien2 = new Alien(gameWidth / 2 + 10, 4, 3, 55, "alien5.png",437, 5);
//                Alien alien3 = new Alien(gameWidth / 2 + 5, 5, 3, 55, "alien5.png", 345, 4);
//                Alien alien4 = new Alien(gameWidth / 2, 3, 5, 55, "alien6.png", 225, 6);
//                Alien alien5 = new Alien(gameWidth / 2 - 5, 5, 3, 55, "alien5.png", 336, 4);
//                Alien alien6 = new Alien(gameWidth / 2 - 10, 4, 3, 55, "alien5.png", 441, 5);
//                Alien alien7 = new Alien(gameWidth / 2 - 15, 1, 3, 55, "alien5.png", 334, 6);
//                aliens.add(alien1);
//                aliens.add(alien2);
//                aliens.add(alien3);
//                aliens.add(alien4);
//                aliens.add(alien5);
//                aliens.add(alien6);
//                aliens.add(alien7);
//            }
//        }


    }

    public boolean isAttackComplete() {
        return aliens.isEmpty();
    }

    public List<Alien> getAliens() {
        return aliens;
    }
}
