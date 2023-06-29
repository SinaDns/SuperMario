package model;

import controller.LevelManager;

public class Checkpoint {

    public int width = 70;
    public int height = 120;
    LevelManager levelManager;
    int x;
    int y;
    boolean isCaught = false;


    Checkpoint(LevelManager levelManager) {
        this.levelManager = levelManager;
    }


}
