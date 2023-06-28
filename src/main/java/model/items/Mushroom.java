package model.items;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Mushroom implements Moveable {

    LevelManager levelManager;
    int x;
    int y;
    int width = 50;
    int height = 50;
    float mushroomSpeed = 0.2f;
    boolean isUsed;


    public Mushroom(int x, int y, LevelManager levelManager) {
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
    }

    @Override
    public void move() {
        x -= mushroomSpeed;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}