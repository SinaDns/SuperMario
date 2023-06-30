package model.items;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Mushroom extends Item implements Moveable {

    LevelManager levelManager;
    int x;
    int y;
    int width = 50;
    int height = 50;
    float mushroomSpeed = 0.2f;
    public boolean isUsed = false;


    public Mushroom(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
    }

    @Override
    public void move() {
        x -= mushroomSpeed;
        this.setLocation(x, y);
    }

}