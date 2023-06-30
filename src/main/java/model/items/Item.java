package model.items;

import controller.LevelManager;
import model.GameObject;

public abstract class Item extends GameObject {

    LevelManager levelManager;

    public int x;
    public int y;
    public int width;
    public int height;




    public Item(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.levelManager = levelManager;
    }


//    public abstract void move();

}
