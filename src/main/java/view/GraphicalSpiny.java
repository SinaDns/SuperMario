package view;

import config.ImageAddresses;
import controller.LevelManager;
import model.Goompa;
import model.Spiny;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalSpiny implements Drawable {

    LevelManager levelManager;

    Spiny spiny;
    BufferedImage spinyImage;

//    Goompa goompa;
//    int xGoompa = 1600;
//    int yGoompa = 400;
//        goompa = new Goompa(xGoompa, yGoompa, levelManager);


    public GraphicalSpiny(LevelManager levelManager, Spiny spiny) {
        this.levelManager = levelManager;
        this.spiny = spiny;
        spinyImage = ImageAddresses.getSprite(ImageAddresses.SPINY);
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {
        g.drawImage(spinyImage, spiny.x - xLvlOffset, spiny.y, 50, 50, null);
    }


}
