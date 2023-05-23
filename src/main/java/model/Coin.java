package model;

import config.ImageAddresses;
import controller.LevelManager;

import java.awt.*;
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
        coinImage = ImageAddresses.getPlayerSprite(ImageAddresses.COIN);
        this.levelManager = levelManager;
    }



//    public void draw(Graphics g, int xlvloffset) {
//
//        if (levelManager.sectionNumber == 1) {
//            if (!drawingCoinsAtSectionOne[0])
//                g.drawImage(coinImage, 450 - xlvloffset, 260, 35, 35, null);
//            if (!drawingCoinsAtSectionOne[1])
//                g.drawImage(coinImage, 700 - xlvloffset, 460, 35, 35, null);
//            if (!drawingCoinsAtSectionOne[2])
//                g.drawImage(coinImage, 800 - xlvloffset, 460, 35, 35, null);
//            if (!drawingCoinsAtSectionOne[3])
//                g.drawImage(coinImage, 1400 - xlvloffset, 290, 35, 35, null);
//            if (!drawingCoinsAtSectionOne[4])
//                g.drawImage(coinImage, 1750 - xlvloffset, 350, 35, 35, null);
//            if (!drawingCoinsAtSectionOne[5])
//                g.drawImage(coinImage, 2000 - xlvloffset, 300, 35, 35, null);
//            if (!drawingCoinsAtSectionOne[6])
//                g.drawImage(coinImage, 2500 - xlvloffset, 460, 35, 35, null);
//        }
//
//        else if (levelManager.sectionNumber == 2) {
//            if (!drawingCoinsAtSectionTwo[0])
//                g.drawImage(coinImage, 600 - xlvloffset, 260, 35, 35, null);
//            if (!drawingCoinsAtSectionTwo[1])
//                g.drawImage(coinImage, 850 - xlvloffset, 460, 35, 35, null);
//            if (!drawingCoinsAtSectionTwo[2])
//                g.drawImage(coinImage, 1100 - xlvloffset, 460, 35, 35, null);
//            if (!drawingCoinsAtSectionTwo[3])
//                g.drawImage(coinImage, 1550 - xlvloffset, 290, 35, 35, null);
//            if (!drawingCoinsAtSectionTwo[4])
//                g.drawImage(coinImage, 1750 - xlvloffset, 350, 35, 35, null);
//            if (!drawingCoinsAtSectionTwo[5])
//                g.drawImage(coinImage, 2000 - xlvloffset, 300, 35, 35, null);
//            if (!drawingCoinsAtSectionTwo[6])
//                g.drawImage(coinImage, 3500 - xlvloffset, 460, 35, 35, null);
//        }
//    }

}
