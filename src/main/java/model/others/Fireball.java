package model.others;

import controller.LevelManager;
import model.Player;
import model.interfaces.Moveable;

public class Fireball extends Throwable implements Moveable {

    public int x;
    public int y;
    public int width = 35;
    public int height = 35;
    public boolean setX = true;
    LevelManager levelManager;
    Player player;
    float fireSpeed = 3.3f;

    public Fireball(int x, int y, int width, int height, LevelManager levelManager, Player player) {
        super(x, y, width, height, levelManager);
        this.levelManager = levelManager;
        this.player = player;
    }

    @Override
    public void move() {

        if (player.isFire()) {

            if (setX) {
                x = player.hitBox.x + 40;
                y = player.hitBox.y + 10;
                setX = false;
            }

            x += fireSpeed;
        }

        this.setLocation(x, y);
    }

}