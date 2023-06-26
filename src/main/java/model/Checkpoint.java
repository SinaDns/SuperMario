package model;

import controller.LevelManager;

import java.awt.image.BufferedImage;

public class Checkpoint {

    LevelManager levelManager;
    int x;
    int y;
    public int width = 70;
    public int height = 120;
    boolean isCaught = false;


    Checkpoint(LevelManager levelManager) {
        this.levelManager = levelManager;
    }



}
