package view.graphicalModel;

import config.ImageAddresses;
import controller.LevelManager;
import model.items.Star;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalStar implements Drawable {

    LevelManager levelManager;
    BufferedImage starImage;
    Star star;

    public GraphicalStar(LevelManager levelManager, Star star) {
        starImage = ImageAddresses.getSprite(ImageAddresses.STAR);
        this.levelManager = levelManager;
        this.star = star;
    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {

        g.drawImage(starImage, 600 - xLvlOffset, 250, 48, 48, null);

    }


}
