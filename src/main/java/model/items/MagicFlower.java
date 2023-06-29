package model.items;

import controller.LevelManager;

import java.awt.geom.Rectangle2D;

public class MagicFlower {

    LevelManager levelManager;
    public int x;
    public int y;
    public int width = 50;
    public int height = 50;

    Rectangle2D.Double magicFlowerRect;


    public MagicFlower(int x, int y, LevelManager levelManager) {
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
        magicFlowerRect = new Rectangle2D.Double(0, 0, 50, 50);
    }




}