package model;

import config.ImageAddresses;
import view.LevelManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pipe {

    LevelManager levelManager;
    BufferedImage pipeImage;

    int pipeWidth = 90;
    int pipeHeight = 110;

    public Pipe(LevelManager levelManager) {
        pipeImage = ImageAddresses.getPlayerSprite(ImageAddresses.PIPE);
        this.levelManager = levelManager;
    }


//    public void draw(Graphics g, int xLvlOffset) {
//
//        if (levelManager.sectionNumber == 1)
//            g.drawImage(pipeImage, 3340 - xLvlOffset, 390, 90, 110, null);
//
//        else if (levelManager.sectionNumber == 2)
//            g.drawImage(pipeImage, 3000 - xLvlOffset, 390, 90, 110, null);
//    }

}
