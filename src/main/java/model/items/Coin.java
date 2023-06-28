package model.items;

import config.ImageAddresses;
import controller.LevelManager;

import java.awt.image.BufferedImage;


public class Coin {

    LevelManager levelManager;
    BufferedImage coinImage;

    int x;
    int y;
    public int width = 35;
    public int height = 35;
    boolean isEaten = false;

    public boolean[] drawingCoinsAtSectionOne = new boolean[20];
    public boolean[] drawingCoinsAtSectionTwo = new boolean[20];



    public Coin(LevelManager levelManager) {
        coinImage = ImageAddresses.getSprite(ImageAddresses.COIN);
        this.levelManager = levelManager;
    }

}
