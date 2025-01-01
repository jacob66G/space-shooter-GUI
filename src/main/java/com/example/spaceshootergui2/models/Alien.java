package com.example.spaceshootergui2.models;

public class Alien  extends Character {

    private int moveInterval;
    private int shootInterval;
    private int startX;
    private int startY;
    private int movingType;
    private boolean movingDown;
    private boolean movingRight;
    private long lastMoveTime = 0;
    private long lastShootTime = 0;

    public Alien(int x, int y, int health, int speed, int moveInterval, String imagePath, int shootInterval, int movingType) {
        super(x, y, health, speed, imagePath);

        this.shootInterval = shootInterval;
        this.destroy = false;
        this.movingRight = true;
        this.movingDown = true;
        this.startX = x;
        this.startY = y;
        this.movingType = movingType;
        this.moveInterval = moveInterval;
    }

    public boolean canShoot() {
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastShootTime >= shootInterval) {
            lastShootTime = currentTime;
            return true;
        }
        return false;
    }

    public void move(int level) {
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastMoveTime >= moveInterval) {
            lastMoveTime = currentTime;
            switch (level) {
                //prawo lewo
                case 1:
                    if (movingRight) {
                        moveRight();
                    } else {
                        moveLeft();
                    }

                    if (x >= startX + 100) {
                        movingRight = false;
                    } else if (x <= startX - 100) {
                        movingRight = true;
                    }
                    break;
                //prawo lewo do konca
                case 2:
                    if (movingRight) {
                        moveRight();
                    } else {
                        moveLeft();
                    }

                    if (x >= startX + 100) {
                        movingRight = false;
                    } else if (x <= startX - 100) {
                        movingRight = true;
                    }
                    break;
                //prostokat
                case 3:
                    if (movingRight) {
                        moveRight();
                        if (x >= startX + 60) {
                            moveDown();
                            movingRight = false;
                        }
                    } else if (!movingRight) {
                        moveLeft();
                        if (x <= startX - 60) {
                            movingRight = true;
                            moveUp();
                        }
                    }
                    break;
                //prawo lewo lewo prawo
                case 4:
                    if (movingRight) {
                        moveRight();
                        if (x >= startX + 50) {
                            movingRight = false;
                        }
                    } else if (!movingRight) {
                        moveLeft();
                        if (x <= startX - 50) {
                            movingRight = true;
                        }
                    }
                    break;
                    //trojkat
                case 5:
                    if (movingRight && movingDown) {
                        moveRight();
                        moveDown();

                        if (x >= startX + 60 && y >= startY + 60) {
                            movingRight = false;
                            movingDown = false;
                        }
                    } else if (!movingRight && !movingDown) {
                        moveLeft();

                        if (x <= startX - 60 && y >= startY + 60) {
                            movingRight = true;
                        }
                    } else if (movingRight && !movingDown) {
                        moveRight();
                        moveUp();

                        if (x == startX && y == startY) {
                            movingRight = true;
                            movingDown = true;
                        }
                    }
                    break;
                //elipsa
                case 6:
                    if (movingRight && movingDown) {
                        moveRight();
                        moveDown();

                        if (x >= startX + 40 && y >= startY + 40) {
                            movingRight = false;
                        }
                    } else if (!movingRight && movingDown) {
                        moveLeft();
                        moveDown();

                        if (x == startX && y == startY + 80) {
                            movingDown = false;
                        }
                    } else if (!movingRight && !movingDown) {
                        moveLeft();
                        moveUp();

                        if (x == startX - 40 && y == startY + 40) {
                            movingRight = true;
                        }
                    } else if (movingRight && !movingDown) {
                        moveRight();
                        moveUp();

                        if (x == startX && y == startY) {
                            movingDown = true;
                            movingRight = true;
                        }
                    }
                    break;
            }
        }
    }

    public void moveUp() {
        if(y < GameModel.GAME_HEIGHT + 1) {
            y--;
        }
    }

    public void moveDown() {
        if(y > 0) {
            y++;
        }
    }

    public int getMovingType() {
        return movingType;
    }
}
