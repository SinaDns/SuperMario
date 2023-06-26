package view;

import config.ImageAddresses;
import controller.LevelManager;
import model.Goompa;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalGoompa implements Drawable {

    LevelManager levelManager;
    Goompa goompa;
    BufferedImage goompaImage;

    public GraphicalGoompa(LevelManager levelManager, Goompa goompa) {
        goompaImage = ImageAddresses.getSprite(ImageAddresses.GOOMPA);
        this.goompa = goompa;
        this.levelManager = levelManager;
    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {
        g.drawImage(goompaImage, goompa.x - xLvlOffset, goompa.y, 50, 50, null);
    }



}
