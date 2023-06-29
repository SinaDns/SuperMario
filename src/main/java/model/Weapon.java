package model;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Weapon implements Moveable {

    public int x;
    public int y;
    public int width = 40;
    public int height = 80;
    public boolean setX = true;
    LevelManager levelManager;
    Player player;
    float releaseSpeed = 3f;

    public Weapon(LevelManager levelManager, Player player) {
        this.player = player;
        this.levelManager = levelManager;
    }

    @Override
    public void move() {


        if (player.weapon) {

            if (setX) {
                x = player.hitBox.x + 40;
                y = player.hitBox.y - 30;
                setX = false;
            }

            x += releaseSpeed;
        }

    }
}