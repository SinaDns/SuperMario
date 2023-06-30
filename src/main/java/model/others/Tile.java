package model.others;

import controller.LevelManager;
import model.GameObject;

import java.awt.image.BufferedImage;

public class Tile extends GameObject {

    LevelManager levelManager;

    public BufferedImage image;
    public boolean collision = false;


    public Tile(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);

    }


    public BufferedImage getImage() {
        return image;
    }
}
