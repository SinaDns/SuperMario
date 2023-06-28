package model;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Weapon implements Moveable {

    public int x;
    public int y;
    public int width = 30;
    public int height = 60;
    public boolean setX = true;
    LevelManager levelManager;
    Player player;
    float releaseSpeed = 1.5f;

    public Weapon(LevelManager levelManager, Player player) {
        this.player = player;
        this.levelManager = levelManager;
    }

    @Override
    public void move() {


        if (player.weapon) {

            if (setX) {
                x = player.hitBox.x + 40;
                System.out.println(x);
                setX = false;
            }

            x += releaseSpeed;
        }

    }
}