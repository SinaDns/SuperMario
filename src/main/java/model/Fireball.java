package model;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Fireball implements Moveable {

    LevelManager levelManager;
    Player player;

    int x;
    int y;
    int width = 30;
    int height = 30;

    float fireSpeed = 1.5f;


    Fireball(int x, int y, LevelManager levelManager, Player player) {
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
        this.player = player;
    }

    @Override
    public void move() {

        x -= fireSpeed;

    }


}
