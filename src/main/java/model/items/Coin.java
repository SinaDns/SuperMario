package model.items;

import config.ImageAddresses;
import controller.LevelManager;

import java.awt.image.BufferedImage;


public class Coin extends Item {

    public int width = 35;
    public int height = 35;
    public boolean[] drawingCoinsAtLevelOneSectionOne = new boolean[20];
    public boolean[] drawingCoinsAtLevelOneSectionTwo = new boolean[20];

    public boolean[] drawingCoinsAtLevelTwoSectionOne = new boolean[20];
    public boolean[] drawingCoinsAtLevelTwoSectionTwo = new boolean[20];


    LevelManager levelManager;
    BufferedImage coinImage;
    public int x;
    public int y;
    public boolean eat = false;


    public Coin(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        this.x = x;
        this.y = y;
        coinImage = ImageAddresses.getSprite(ImageAddresses.COIN);
        this.levelManager = levelManager;
    }




}