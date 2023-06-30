package model.others;

import controller.LevelManager;

public class Checkpoint {

    public int width = 70;
    public int height = 120;
    LevelManager levelManager;
    int x;
    int y;
    boolean isCaught = false;


    public Checkpoint(LevelManager levelManager) {
        this.levelManager = levelManager;
    }


}
