package view;

import config.ImageAddresses;
import controller.LevelManager;
import model.OgreMagi;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalOgreMagi implements Drawable {

    LevelManager levelManager;
    OgreMagi ogreMagi;
    BufferedImage ogreImage;
    BufferedImage ogreArcanaImage;
    BufferedImage healthBarImage;

    public GraphicalOgreMagi(LevelManager levelManager, OgreMagi ogreMagi) {
        this.levelManager = levelManager;
        this.ogreMagi = ogreMagi;
        ogreImage = ImageAddresses.getSprite(ImageAddresses.BOSS);
        ogreArcanaImage = ImageAddresses.getSprite(ImageAddresses.TRIGGERED_BOSS);
        healthBarImage = ImageAddresses.getSprite(ImageAddresses.HEALTH_BAR_2);
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {

        g.drawImage(ogreImage, ogreMagi.x - xLvlOffset, ogreMagi.y, 200, 200, null);

        // Health logic somehow TODO
        g.setColor(new Color(216, 49, 49));
        g.fillRect(120 - xLvlOffset, 72, 1040, 20);
        g.drawImage(healthBarImage, 120 - xLvlOffset, 72, 1040, 20, null);

        g.setColor(new Color(130, 44, 44, 255));
        g.setFont(new Font("Courier", Font.BOLD, 18));
        g.drawString("Aggron Stonebreak, the Ogre Magi", 140 - xLvlOffset, 120);

    }




}
