package model.others;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Bomb extends Throwable implements Moveable {


    public int x;
    public int y;
    public boolean isBombReleased = false;
    public int width = 25;
    public int height = 50;
    LevelManager levelManager;
    float bombSpeed = 0.1f;

    public Bomb(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        this.levelManager = levelManager;
    }

    @Override
    public void move() {

        x = levelManager.getGame().nukeBird.x;

        if (isBombReleased)
            y += bombSpeed;

        this.setLocation(x, y);
    }
}
