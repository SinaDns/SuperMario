package model.others;

import controller.LevelManager;
import model.Player;
import model.interfaces.Moveable;

public class Weapon extends Throwable implements Moveable {

    public int x;
    public int y;
    public int width = 40;
    public int height = 80;
    public boolean setX = true;
    LevelManager levelManager;
    Player player;
    float releaseSpeed = 3f;

    public Weapon(int x, int y, int width, int height, LevelManager levelManager, Player player) {
        super(x, y, width, height, levelManager);
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
        this.player = player;
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