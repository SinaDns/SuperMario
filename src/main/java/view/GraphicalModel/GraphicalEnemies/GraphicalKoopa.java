package view.GraphicalModel.GraphicalEnemies;

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
    BufferedImage koopaPhaseTwoImage;

    public GraphicalKoopa(LevelManager levelManager, Koopa koopa) {
        this.koopa = koopa;
        this.levelManager = levelManager;
        koopaImage = ImageAddresses.getSprite(ImageAddresses.KOOPA);
        koopaPhaseTwoImage = ImageAddresses.getSprite(ImageAddresses.KOOPA_PHASE_TWO);
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {

//        System.out.println(koopa.isAlive);

        if (koopa.isAlive)
            g.drawImage(koopaImage, koopa.x - xLvlOffset, koopa.y, koopa.width, koopa.height, null);
        else {
            g.drawImage(koopaPhaseTwoImage, koopa.x - xLvlOffset, koopa.y, koopa.width, koopa.height, null);
        }
    }

}
