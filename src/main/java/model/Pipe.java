package model;

import config.ImageAddresses;
import controller.LevelManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pipe {

    LevelManager levelManager;
    BufferedImage pipeImage;

    public Pipe(LevelManager levelManager) {
        pipeImage = ImageAddresses.getPlayerSprite(ImageAddresses.PIPE);
        this.levelManager = levelManager;
    }


    public void draw(Graphics g, int xlvloffset) {

        if (levelManager.sectionNumber == 1)
            g.drawImage(pipeImage, 3340 - xlvloffset, 390, 90, 110, null);

        else if (levelManager.sectionNumber == 2)
            g.drawImage(pipeImage, 3000 - xlvloffset, 390, 90, 110, null);
    }
}
