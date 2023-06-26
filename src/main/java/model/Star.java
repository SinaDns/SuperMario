package model;

import controller.LevelManager;

public class Star extends Item {

    boolean isUsed;

    public Star(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
    }

    @Override
    public void move() {

    }


    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
