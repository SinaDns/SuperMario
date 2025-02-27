package model;

import config.ImageAddresses;
import controller.LevelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Plant {

    LevelManager levelManager;
    BufferedImage plantImage;
    BufferedImage pashaImage;
    public int y1Flower = 355;
    public int y2Flower = 312;

    public int x1Flower = 3360;
    public int x2Flower = 3000;


    Plant(LevelManager levelManager) {
        this.levelManager = levelManager;
        plantImage = ImageAddresses.getPlayerSprite(ImageAddresses.FLOWER);
        pashaImage = ImageAddresses.getPlayerSprite(ImageAddresses.PASHA);
    }



    public void draw(Graphics g, int xlvloffset) {


        if (levelManager.sectionNumber == 1)
            g.drawImage(plantImage, x1Flower - xlvloffset, y1Flower, 45, 45, null);
        else if (levelManager.sectionNumber == 2) {
            g.drawImage(pashaImage, x2Flower - xlvloffset, y2Flower, 90, 90, null);
        }
    }


}