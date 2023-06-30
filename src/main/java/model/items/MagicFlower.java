package model.items;

import controller.LevelManager;
import model.interfaces.Moveable;

public class MagicFlower extends Item implements Moveable {

    LevelManager levelManager;
    public int x;
    public int y;
    public int width = 50;
    public int height = 50;


    public MagicFlower(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
    }

    @Override
    public void move() {

    }

}