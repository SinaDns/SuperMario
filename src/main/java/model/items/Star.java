package model.items;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Star extends Item implements Moveable {

    public int x;
    public int y;
    public int width = 50;
    public int height = 50;

    float starSpeed = 0.2f;
    public boolean isUsed;


    public Star(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
    }

    @Override
    public void move() {
        x -= starSpeed;
        this.setLocation(x, y);
    }


    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
