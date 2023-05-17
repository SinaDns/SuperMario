package model;

import view.Drawable;

import java.awt.*;

public class Enemies extends Rectangle implements Drawable {


    Enemies(int x, int y, int ENEMY_WIDTH, int ENEMY_HEIGHT) {
        super(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {

    }




}
