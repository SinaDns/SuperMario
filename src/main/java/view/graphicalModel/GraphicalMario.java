package view.graphicalModel;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import config.ImageAddresses;
import controller.LevelManager;
import model.Player;
import model.User;
import view.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalMario implements Drawable {

    LevelManager levelManager;
    Player player;
    //    @JsonIgnore
    private BufferedImage[] afkAni;


    public GraphicalMario(LevelManager levelManager, Player player) {
        this.levelManager = levelManager;
        this.player = player;

    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {

    }


    public void loadAnimations() {
        BufferedImage imageRed = ImageAddresses.getSprite(ImageAddresses.RED_MARIO);
        BufferedImage imagePink = ImageAddresses.getSprite(ImageAddresses.PINK_MARIO);
        BufferedImage imageGreen = ImageAddresses.getSprite(ImageAddresses.GREEN_MARIO);
        BufferedImage imageYellow = ImageAddresses.getSprite(ImageAddresses.YELLOW_MARIO);
        BufferedImage imageBlack = ImageAddresses.getSprite(ImageAddresses.BLACK_MARIO);

        afkAni = new BufferedImage[2];

        if (User.loggedInUser.get(0).isRedBought() && User.loggedInUser.get(0).isRedChoose())
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imageRed.getSubimage(i * 200, 0, 200, 280);
            }

        if (User.loggedInUser.get(0).isPinkBought() && User.loggedInUser.get(0).isPinkChoose())
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imagePink.getSubimage(i * 200, 0, 200, 280);
            }

        if (User.loggedInUser.get(0).isYellowBought() && User.loggedInUser.get(0).isYellowChoose())
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imageYellow.getSubimage(i * 200, 0, 200, 280);
            }

        if (User.loggedInUser.get(0).isGreenBought() && User.loggedInUser.get(0).isGreenChoose())
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imageGreen.getSubimage(i * 200, 0, 200, 280);
            }

        if (User.loggedInUser.get(0).isBlackBought() && User.loggedInUser.get(0).isBlackChoose())
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imageBlack.getSubimage(i * 200, 0, 200, 280);
            }
    }


}
