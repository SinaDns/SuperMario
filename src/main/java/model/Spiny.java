package model;

import controller.LevelManager;

public class Spiny implements Moveable{

    LevelManager levelManager;
    public int x = 1400;
    public int y = 450;
    float spinySpeed = 0.03f;


    public Spiny(LevelManager levelManager) {
        this.levelManager = levelManager;
    }


    @Override
    public void move() {
        x -= spinySpeed;
    }


}
