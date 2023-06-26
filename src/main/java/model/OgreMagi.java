package model;

import controller.LevelManager;

public class OgreMagi implements Moveable {

    public int x = 1000;
    public int y = 330;
    public int distance;
    LevelManager levelManager;
    float ogreSpeed = -1f;

    public OgreMagi(LevelManager levelManager) {
        this.levelManager = levelManager;
    }


    @Override
    public void move() {

        x += ogreSpeed;

        if (x < (145)) {
            ogreSpeed = -ogreSpeed;
        }
        else if (x > 1000) {
            ogreSpeed = -ogreSpeed;
        }


    }

}