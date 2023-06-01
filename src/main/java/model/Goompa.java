package model;

import controller.LevelManager;

public class Goompa extends Enemy implements Move {

    public int x;
    public int y;
    int width;
    int height;
    double goombaSpeed = 0.01;


    public Goompa(int x, int y, LevelManager levelManager) {
        super(x, y, levelManager);
    }


    public void move() {
        this.x += goombaSpeed;
    }



}
