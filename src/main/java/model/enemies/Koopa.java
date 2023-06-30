package model.enemies;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Koopa extends Enemy implements Moveable {

    public int x;
    public int y;
    public int width = 50;
    public int height = 50;
    LevelManager levelManager;
    float koopaSpeed = 0.03f;

    public boolean isAlive = true;

    public Koopa(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
    }

    @Override
    public void move() {

        x -= koopaSpeed;
        this.setLocation(x, y);

        if (x == 0) {
            koopaSpeed *= -1;
        }
    }

}
