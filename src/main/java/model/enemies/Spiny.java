package model.enemies;

import config.Constants;
import controller.LevelManager;
import model.Player;
import model.interfaces.Moveable;

public class Spiny implements Moveable {

    public int x;
    public int y;
    public int width = 50;
    public int height = 50;
    public int distance;
    Player player;
    LevelManager levelManager;
    float spinySpeed = 0.01f;
    float acceleration = 0.02f;

    public Spiny(int x, int y, LevelManager levelManager, int distance, Player player) {
        this.levelManager = levelManager;
        this.x = x;
        this.y = y;
        this.player = player;
        this.distance = distance;
    }

    @Override
    public void move() {

        distance = (player.hitBox.x - this.x);


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