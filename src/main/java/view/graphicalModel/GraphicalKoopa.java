package view.graphicalModel;

import config.ImageAddresses;
import controller.LevelManager;
import model.enemies.Koopa;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalKoopa implements Drawable {

    LevelManager levelManager;
    Koopa koopa;
    BufferedImage koopaImage;

    public GraphicalKoopa(LevelManager levelManager, Koopa koopa) {
        this.koopa = koopa;
        this.levelManager = levelManager;
        koopaImage = ImageAddresses.getSprite(ImageAddresses.KOOPA);
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {
        g.drawImage(koopaImage, koopa.x - xLvlOffset, koopa.y, koopa.width, koopa.height, null);
    }

}
