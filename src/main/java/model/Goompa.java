package model;

import controller.LevelManager;

public class Goompa implements Moveable {

    LevelManager levelManager;
    public int x = 1600;
    public int y = 230;
    int width;
    int height;
    float goombaSpeed = 0.03f;

    public Goompa(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    public void move() {
        x -= goombaSpeed;
    }

}