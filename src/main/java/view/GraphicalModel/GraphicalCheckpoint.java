package view.GraphicalModel;

import config.ImageAddresses;
import controller.LevelManager;
import model.others.Checkpoint;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalCheckpoint implements Drawable {

    LevelManager levelManager;
    BufferedImage checkPointImage;
    Checkpoint checkpoint;

    public GraphicalCheckpoint(LevelManager levelManager, Checkpoint checkpoint) {
        checkPointImage = ImageAddresses.getSprite(ImageAddresses.CHECKPOINT_FLAG);
        this.levelManager = levelManager;
        this.checkpoint = checkpoint;
    }


    @Override
    public void draw(Graphics g, int xLvlOffset) {
        g.drawImage(checkPointImage, 5760 - xLvlOffset, 388, checkpoint.width, checkpoint.height, null);
    }


}
