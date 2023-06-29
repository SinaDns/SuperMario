package view.graphicalModel;

import config.ImageAddresses;
import controller.LevelManager;
import model.enemies.Goompa;
import view.Drawable;

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

        if (goompa.isAlive)
            g.drawImage(goompaImage, goompa.x - xLvlOffset, goompa.y, goompa.width, goompa.height, null);


        System.out.println(goompa.isAlive);


    }


}
