package model.enemies;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Koopa implements Moveable {

    public int x;
    public int y;
    public int width = 50;
    public int height = 50;
    LevelManager levelManager;
    float koopaSpeed = 0.03f;

    public Koopa(int x, int y, LevelManager levelManager) {
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
    }

    @Override
    public void move() {
        x -= koopaSpeed;

        if (x == 0) {
            koopaSpeed *= -1;
        }
    }

}
