package model.enemies;

import controller.LevelManager;
import model.GameObject;

public class Enemy extends GameObject {

    LevelManager levelManager;

    int x;
    int y;
    int width;
    int height;

    public boolean isAlive = true;


    public Enemy(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        this.levelManager = levelManager;
    }



}