package model.items;

import controller.LevelManager;

public abstract class Item {

    LevelManager levelManager;

    int x;
    int y;
    int width;
    int height;


    public Item(int x, int y, int width, int height, LevelManager levelManager) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.levelManager = levelManager;
    }


    public abstract void move();

}
