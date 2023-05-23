package view;

import config.ImageAddresses;
import controller.LevelManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalPipe implements Drawable {

    LevelManager levelManager;
    BufferedImage pipeImage;

    public GraphicalPipe(LevelManager levelManager) {
        pipeImage = ImageAddresses.getPlayerSprite(ImageAddresses.PIPE);
        this.levelManager = levelManager;
    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {

        if (levelManager.sectionNumber == 1)
            g.drawImage(pipeImage, 3340 - xLvlOffset, 390, 90, 110, null);

        else if (levelManager.sectionNumber == 2)
            g.drawImage(pipeImage, 3000 - xLvlOffset, 390, 90, 110, null);

    }



}
