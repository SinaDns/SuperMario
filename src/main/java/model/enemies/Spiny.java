package model.enemies;

import config.Constants;
import controller.LevelManager;
import model.Player;
import model.interfaces.Moveable;

public class Spiny extends Enemy implements Moveable {

    public int x;
    public int y;
    public int width = 50;
    public int height = 50;
    public int distance;
    Player player;
    LevelManager levelManager;
    float spinySpeed = 0.01f;
    float acceleration = 0.02f;

    public Spiny(int x, int y, int width, int height, LevelManager levelManager, int distance, Player player) {
        super(x, y, width, height, levelManager);
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
        this.player = player;
        this.distance = distance;
    }

    @Override
    public void move() {

        distance = (player.hitBox.x - this.x);

        this.setLocation(x, y);

        if (Math.abs(distance) <= 8 * Constants.TILES_SIZE && player.hitBox.y + player.hitBox.height >= y + height - 30) {

            spinySpeed += acceleration;

            if (distance < 0)
                x -= spinySpeed;
            else
                x += spinySpeed;

        } else {
            spinySpeed = 0.01f;
            x -= spinySpeed;
        }


    }


}