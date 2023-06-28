package view.graphicalModel;

import config.ImageAddresses;
import controller.LevelManager;
import model.Bomb;
import view.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GraphicalBomb implements Drawable {

    LevelManager levelManager;
    Bomb bomb;
    BufferedImage bombImage;
    Timer timer;


    public GraphicalBomb(LevelManager levelManager, Bomb bomb) {
        this.bomb = bomb;
        this.levelManager = levelManager;
        bombImage = ImageAddresses.getSprite(ImageAddresses.BOMB);
    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {

//        timer = new Timer(3000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        timer.start();
//        timer.setRepeats(true);


        if (bomb.isBombReleased)
            g.drawImage(bombImage, bomb.x - xLvlOffset, bomb.y, bomb.width, bomb.height, null);

    }

}