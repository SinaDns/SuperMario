package model.boss;

import config.Constants;
import controller.LevelManager;
import model.Player;
import model.enemies.Enemy;
import model.interfaces.Moveable;

public class OgreMagi extends Enemy implements Moveable {

    public int x;
    public int y;
    public int width = 200;
    public int height = 200;
    public int HP = 20;
    public int distance;
    public boolean jumpAttack;
    Player player;
    LevelManager levelManager;
    float ogreSpeed = -0.5f;
    float airSpeed = -1f;
    boolean normalShot;
    boolean jumpShot;

    public OgreMagi(int x, int y, int width, int height, LevelManager levelManager, int distance, Player player) {
        super(x, y, width, height, levelManager);
        this.levelManager = levelManager;
        this.distance = distance;
        this.player = player;
    }


    public void attack() {
    }

    public void hpHandling() {

        if (normalShot)
            HP -= 1;

        if (jumpShot)
            HP -= 3;

    }


    @Override
    public void move() {
        // Default Move
        x += ogreSpeed;

        if (x < (3 * Constants.TILES_SIZE))
            ogreSpeed = -ogreSpeed;
        else if (x > 1000)
            ogreSpeed = -ogreSpeed;

        distance = Math.abs(this.x - player.hitBox.x);
        System.out.println(distance);


        if (distance > 8 * Constants.TILES_SIZE) {
            // ogreSpeed = 1.5f * ogreSpeed;
        } else ogreSpeed = -0.5f;


        // Jump to Attack, Move
        if (jumpAttack) {
            y += airSpeed;

            if (y + width >= 500) {
            }
        }

    }

}