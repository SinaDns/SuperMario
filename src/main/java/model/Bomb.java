package model;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Bomb implements Moveable {

    public int x;
    public int y = 150;
    public boolean isBombReleased = false;
    public int width = 25;
    public int height = 50;
    LevelManager levelManager;
    float bombSpeed = 0.1f;

    public Bomb(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    @Override
    public void move() {

        if (isBombReleased)
            y += bombSpeed;
    }
}
