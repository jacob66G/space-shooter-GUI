package com.example.spaceshootergui2.models;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int levelNumber;
    private int currentAttackIndex;
    private List<Attack> attacks;
    private int numOfAttacks = 0;

    public Level(int levelNumber) {
        this.levelNumber = levelNumber;
        this.currentAttackIndex = 0;
        this.attacks = new ArrayList<>();

        createAttack();
    }

    public void createAttack() {

        if(levelNumber == 1) numOfAttacks=3;
        else if(levelNumber == 2) numOfAttacks=3;
        else if(levelNumber == 3) numOfAttacks=3;

        for (int i = 0; i < numOfAttacks; i++) {
            Attack attack = new Attack(i + 1, levelNumber);
            attacks.add(attack);
        }
    }

    public boolean isLevelComplete() {
        return  currentAttackIndex == numOfAttacks;
    }

    public void nextAttack() {
        currentAttackIndex++;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }
}
