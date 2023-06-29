package view.graphicalModel;

import config.ImageAddresses;
import controller.LevelManager;
import model.Fireball;
import model.Player;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalFireball implements Drawable {

    LevelManager levelManager;
    Player player;
    Fireball fireball;
    BufferedImage fireballImage;


    public GraphicalFireball(LevelManager levelManager, Player player, Fireball fireball) {
        this.levelManager = levelManager;
        this.player = player;
        this.fireball = fireball;
        fireballImage = ImageAddresses.getSprite(ImageAddresses.FIREBALL);
    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {

        if (player.isFire())
            g.drawImage(fireballImage, fireball.x - xLvlOffset, fireball.y, fireball.width, fireball.height, null);
    }


}
