package model;

import controller.LevelManager;

public class Koopa implements Moveable {

    LevelManager levelManager;
    public int x = 1800;
    public int y = 150;
    float koopaSpeed = 0.03f;

    public Koopa(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    @Override
    public void move() {
        x -= koopaSpeed;
    }

}
