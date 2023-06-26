package model;

import config.ImageAddresses;
import controller.LevelManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pipe {

    public int x;
    public int y;
    LevelManager levelManager;
    BufferedImage pipeImage;

    public Pipe(LevelManager levelManager) {
        pipeImage = ImageAddresses.getSprite(ImageAddresses.PIPE);
        this.levelManager = levelManager;
    }


}