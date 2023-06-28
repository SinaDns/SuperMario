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

        g.drawImage(goompaImage, goompa.x - xLvlOffset, goompa.y, goompa.width, goompa.height, null);

//        switch (levelManager.levelNumber) {
//
//            case 1:
//                switch (levelManager.sectionNumber) {
//
//                    case 1:
//                        break;
//
//                    case 2:
//                        break;
//                }
//                break;
//
//
//            case 2:
//                switch (levelManager.sectionNumber) {
//
//                    case 1:
//                        break;
//
//                    case 2:
//                        break;
//                }
//                break;
//
//
//            case 3:
//                switch (levelManager.sectionNumber) {
//
//                    case 1:
//                        break;
//
//                    case 2:
//                        break;
//                }
//                break;
//
//
//            case 5:
//                switch (levelManager.sectionNumber) {
//
//                    case 1:
//                        break;
//
//                    case 2:
//                        break;
//                }
//                break;
//        }
    }


}
