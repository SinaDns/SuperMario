package model.enemies;

import controller.LevelManager;
import model.interfaces.Moveable;

public class Goompa extends Enemy implements Moveable {

    public int x;
    public int y;
    public int width = 50;
    public int height = 50;
    LevelManager levelManager;
    float goompaSpeed = 0.025f;

    public Goompa(int x, int y, LevelManager levelManager) {
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
    }

    public void move() {


        x -= goompaSpeed;


    }

}