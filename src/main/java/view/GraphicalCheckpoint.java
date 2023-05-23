package view;

import config.ImageAddresses;
import controller.LevelManager;
import model.Checkpoint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalCheckpoint implements Drawable {

    LevelManager levelManager;
    BufferedImage checkPointImage;
    Checkpoint checkpoint;

    public GraphicalCheckpoint(LevelManager levelManager, Checkpoint checkpoint) {
        checkPointImage = ImageAddresses.getPlayerSprite(ImageAddresses.CHECKPOINT_FLAG);
        this.levelManager = levelManager;
        this.checkpoint = checkpoint;
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {
        g.drawImage(checkPointImage,  1000 - xLvlOffset, 300, checkpoint.width, checkpoint.height, null);
    }


}
