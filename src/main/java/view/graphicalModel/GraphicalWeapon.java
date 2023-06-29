package view.graphicalModel;

import config.ImageAddresses;
import controller.LevelManager;
import model.Player;
import model.Weapon;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalWeapon implements Drawable {

    LevelManager levelManager;
    Weapon weapon;
    Player player;
    BufferedImage marioWeapon;

    public GraphicalWeapon(LevelManager levelManager, Player player, Weapon weapon) {
        this.levelManager = levelManager;
        this.player = player;
        this.weapon = weapon;
        marioWeapon = ImageAddresses.getSprite(ImageAddresses.SWORD);
    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {

        if (player.weapon)
            g.drawImage(marioWeapon, weapon.x - xLvlOffset, weapon.y, weapon.width, weapon.height, null);

    }
}
