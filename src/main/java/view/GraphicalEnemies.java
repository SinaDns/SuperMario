package view;

import config.ImageAddresses;
import controller.LevelManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalEnemies implements Drawable {

    LevelManager levelManager;

    BufferedImage goompaImage;
    BufferedImage spinyImage;

//    BufferedImage


    public GraphicalEnemies(LevelManager levelManager) {
        this.levelManager = levelManager;
        spinyImage = ImageAddresses.getPlayerSprite(ImageAddresses.SPINY);
        goompaImage = ImageAddresses.getPlayerSprite(ImageAddresses.GOOMPA);
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {


        g.drawImage(spinyImage, 1400 - xLvlOffset, 530, 50, 50, null);


        g.drawImage(goompaImage, 1600 - xLvlOffset, 400, 50, 50, null);


    }


}
