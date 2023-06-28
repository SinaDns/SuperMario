package view.graphicalModel;

import config.ImageAddresses;
import controller.LevelManager;
import model.items.Mushroom;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalMushroom implements Drawable {

    LevelManager levelManager;
    Mushroom mushroom;
    BufferedImage mushroomImage;

    public GraphicalMushroom(LevelManager levelManager, Mushroom mushroom) {
        mushroomImage = ImageAddresses.getSprite(ImageAddresses.MUSHROOM);
        this.mushroom = mushroom;
        this.levelManager = levelManager;
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {
        g.drawImage(mushroomImage, mushroom.getX() - xLvlOffset, mushroom.getY(), mushroom.getWidth(), mushroom.getHeight(), null);
    }


}
