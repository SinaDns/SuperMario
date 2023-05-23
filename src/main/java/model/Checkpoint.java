package model;

import controller.LevelManager;

import java.awt.image.BufferedImage;

public class Checkpoint {

    LevelManager levelManager;
    BufferedImage checkPointImage;
    int x;
    int y;
    public int width = 70;
    public int height = 120;
    boolean isEaten = false;


    Checkpoint(LevelManager levelManager) {
        this.levelManager = levelManager;
    }



}
