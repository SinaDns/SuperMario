package model;

import controller.LevelManager;

import java.awt.*;

public class GameObject extends Rectangle {

    LevelManager levelManager;
    public int x;
    public int y;
    public int width;
    public int height;

    public GameObject(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height);
        this.levelManager = levelManager;
    }


}