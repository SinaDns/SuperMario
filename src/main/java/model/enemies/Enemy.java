package model.enemies;

import controller.LevelManager;

public class Enemy {

    LevelManager levelManager;

    int x;
    int y;
    int width;
    int height;



    Enemy(int x, int y, LevelManager levelManager) {
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
    }

    public Enemy() {
    }

}
