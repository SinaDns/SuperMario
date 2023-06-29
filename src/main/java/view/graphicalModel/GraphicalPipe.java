package view.graphicalModel;

import config.ImageAddresses;
import controller.LevelManager;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalPipe implements Drawable {

    LevelManager levelManager;
    BufferedImage pipeImage;

    public GraphicalPipe(LevelManager levelManager) {
        pipeImage = ImageAddresses.getSprite(ImageAddresses.PIPE);
        this.levelManager = levelManager;
    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {

        // HIDDEN PIPE IN LEVEL 1
        if (levelManager.levelNumber == 1 && levelManager.sectionNumber == 2)
            g.drawImage(pipeImage, 4100 - xLvlOffset, 350, 90, 150, null);

        // HIDDEN PIPE IN LEVEL 2 (First one is the hidden one)
        if (levelManager.levelNumber == 2 && levelManager.sectionNumber == 2) {
            g.drawImage(pipeImage, 4800 - xLvlOffset, 300, 90, 200, null);
            g.drawImage(pipeImage, 4550 - xLvlOffset, 400, 90, 100, null);
        }


        if (levelManager.sectionNumber == 1)
            g.drawImage(pipeImage, 3340 - xLvlOffset, 390, 90, 110, null);

        else if (levelManager.sectionNumber == 2)
            g.drawImage(pipeImage, 3000 - xLvlOffset, 390, 90, 110, null);
    }


}
