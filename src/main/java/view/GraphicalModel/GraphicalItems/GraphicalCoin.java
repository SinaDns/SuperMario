package view.GraphicalModel.GraphicalItems;

import config.ImageAddresses;
import controller.LevelManager;
import model.items.Coin;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalCoin implements Drawable {

    LevelManager levelManager;
    BufferedImage coinImage;
    Coin coin;

    public GraphicalCoin(LevelManager levelManager, Coin coin) {
        coinImage = ImageAddresses.getSprite(ImageAddresses.COIN);
        this.levelManager = levelManager;
        this.coin = coin;
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {

        // DRAWING COINS AT LEVEL 1
        if (levelManager.levelNumber == 1 && levelManager.sectionNumber == 1) {
            if (!coin.drawingCoinsAtLevelOneSectionOne[0])
                g.drawImage(coinImage, 450 - xLvlOffset, 260, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionOne[1])
                g.drawImage(coinImage, 700 - xLvlOffset, 460, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionOne[2])
                g.drawImage(coinImage, 800 - xLvlOffset, 460, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionOne[3])
                g.drawImage(coinImage, 1400 - xLvlOffset, 290, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionOne[4])
                g.drawImage(coinImage, 1750 - xLvlOffset, 350, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionOne[5])
                g.drawImage(coinImage, 2000 - xLvlOffset, 300, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionOne[6])
                g.drawImage(coinImage, 2500 - xLvlOffset, 460, 35, 35, null);
        } else if (levelManager.levelNumber == 1 && levelManager.sectionNumber == 2) {
            if (!coin.drawingCoinsAtLevelOneSectionTwo[0])
                g.drawImage(coinImage, 600 - xLvlOffset, 260, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionTwo[1])
                g.drawImage(coinImage, 850 - xLvlOffset, 460, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionTwo[2])
                g.drawImage(coinImage, 1100 - xLvlOffset, 460, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionTwo[3])
                g.drawImage(coinImage, 1550 - xLvlOffset, 290, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionTwo[4])
                g.drawImage(coinImage, 1750 - xLvlOffset, 350, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionTwo[5])
                g.drawImage(coinImage, 2000 - xLvlOffset, 300, 35, 35, null);
            if (!coin.drawingCoinsAtLevelOneSectionTwo[6])
                g.drawImage(coinImage, 3500 - xLvlOffset, 460, 35, 35, null);
        }


        // DRAWING COINS AT LEVEL 2

        if (levelManager.levelNumber == 2 && levelManager.sectionNumber == 1) {

            for (Coin coin : levelManager.getGame().coinArrayList) {

                if (!coin.eat)
                    g.drawImage(coinImage, coin.x - xLvlOffset, coin.y, 35, 35, null);
            }

        }


    }


}
