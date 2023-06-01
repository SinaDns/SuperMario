package view;

import config.ImageAddresses;
import controller.LevelManager;
import model.Goompa;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalEnemies implements Drawable {

    LevelManager levelManager;
    Goompa goompa;


    BufferedImage spinyImage;

    int xGoompa = 1600;
    int yGoompa = 400;


    public GraphicalEnemies(LevelManager levelManager) {
        this.levelManager = levelManager;
        goompa = new Goompa(xGoompa, yGoompa, levelManager);
        spinyImage = ImageAddresses.getSprite(ImageAddresses.SPINY);
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {


        g.drawImage(spinyImage, 1400 - xLvlOffset, 330, 50, 50, null);

    }


}
