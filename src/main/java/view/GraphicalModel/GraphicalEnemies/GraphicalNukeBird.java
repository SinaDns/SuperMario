package view.GraphicalModel.GraphicalEnemies;

import config.ImageAddresses;
import controller.LevelManager;
import model.Game;
import model.enemies.NukeBird;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalNukeBird implements Drawable {

    LevelManager levelManager;
    NukeBird nukeBird;
    BufferedImage nukebirdImage;


    public GraphicalNukeBird(LevelManager levelManager, NukeBird nukeBird) {
        nukebirdImage = ImageAddresses.getSprite(ImageAddresses.NUKEBIRD);
        this.nukeBird = nukeBird;
        this.levelManager = levelManager;
    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {

        if (!Game.isInBossFight && nukeBird.isAlive) {
            g.drawImage(nukebirdImage, nukeBird.x - xLvlOffset, nukeBird.y, nukeBird.width, nukeBird.height, null);
        }

    }


}