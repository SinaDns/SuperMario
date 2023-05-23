package view;

import config.ImageAddresses;
import controller.LevelManager;
import model.Plant;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalPlant implements Drawable {

    Plant plant;
    LevelManager levelManager;
    BufferedImage plantImage;
    BufferedImage pashaImage;

//    int y1Flower = 355;
//    int y2Flower = 312;
//    int x1Flower = 3360;
//    int x2Flower = 3000;

    public GraphicalPlant(LevelManager levelManager, Plant plant) {
        this.levelManager = levelManager;
        this.plant = plant;
        plantImage = ImageAddresses.getPlayerSprite(ImageAddresses.FLOWER);
        pashaImage = ImageAddresses.getPlayerSprite(ImageAddresses.PASHA);
    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {
        if (levelManager.sectionNumber == 1)
            g.drawImage(plantImage, plant.x1Flower - xLvlOffset, plant.y1Flower, 45, 45, null);
        else if (levelManager.sectionNumber == 2)
            g.drawImage(pashaImage, plant.x2Flower - xLvlOffset, plant.y2Flower, 90, 90, null);
    }

}
