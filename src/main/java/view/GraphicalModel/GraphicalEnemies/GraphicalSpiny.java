package view.GraphicalModel.GraphicalEnemies;

import config.ImageAddresses;
import controller.LevelManager;
import model.enemies.Spiny;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalSpiny implements Drawable {

    LevelManager levelManager;
    Spiny spiny;
    BufferedImage spinyImage;


    public GraphicalSpiny(LevelManager levelManager, Spiny spiny) {
        this.levelManager = levelManager;
        this.spiny = spiny;
        spinyImage = ImageAddresses.getSprite(ImageAddresses.SPINY);
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {

        if (spiny.isAlive)
            g.drawImage(spinyImage, spiny.x - xLvlOffset, spiny.y, spiny.width, spiny.height, null);
    }


}
