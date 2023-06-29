package model.items;

import config.ImageAddresses;
import controller.LevelManager;

import java.awt.image.BufferedImage;


public class Coin {

    public int width = 35;
    public int height = 35;
    public boolean[] drawingCoinsAtLevelOneSectionOne = new boolean[20];
    public boolean[] drawingCoinsAtLevelOneSectionTwo = new boolean[20];

    public boolean[] drawingCoinsAtLevelTwoSectionOne = new boolean[20];
    public boolean[] drawingCoinsAtLevelTwoSectionTwo = new boolean[20];


    LevelManager levelManager;
    BufferedImage coinImage;
    int x;
    int y;
    boolean isEaten = false;


    public Coin(LevelManager levelManager) {
        coinImage = ImageAddresses.getSprite(ImageAddresses.COIN);
        this.levelManager = levelManager;
    }

//    public Coin(int x, int y, LevelManager levelManager) {
//        this.x = x;
//        this.y = y;
//        this.levelManager = levelManager;
//    }


}