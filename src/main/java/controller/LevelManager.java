package controller;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import config.ImageAddresses;
import model.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {

    public int levelNumber;
    public int sectionNumber;

    private Game game;
    //    @JsonIgnore
    private BufferedImage section1Sprite;
    //    @JsonIgnore
    private BufferedImage section2Sprite;


    public LevelManager(Game game, int levelNumber, int sectionNumber) {
        this.game = game;
        this.sectionNumber = sectionNumber;
        this.levelNumber = levelNumber;
        section1Sprite = ImageAddresses.getSprite(ImageAddresses.section1);
        section2Sprite = ImageAddresses.getSprite(ImageAddresses.section2);
    }

    public LevelManager() {

    }


    public void draw(Graphics g, int xLvlOffset, int lives, int coins, int score) {

//        System.out.println("Level: " + levelNumber + " | Section: " + sectionNumber);

        switch (levelNumber) {

            case 1:
                switch (sectionNumber) {
                    case 1 -> {
                        g.drawArc(0, 0, 0, 0, 0, 0);
                        g.drawImage(section1Sprite, -xLvlOffset, 0, 5120, 720, null);
                    }
                    case 2 -> {
                        g.drawImage(section2Sprite, -xLvlOffset, 0, 5120, 720, null);
                        // DRAWING TILES (COMPLICATED ONE)
                        g.drawImage(TileManager.tiles[0].image, 631 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 681 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 731 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 781 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 831 - xLvlOffset, 311, 48, 48, null);
                    }
                }
                break;

            case 2:
                switch (sectionNumber) {
                    case 1 -> {
                        g.drawImage(section1Sprite, -xLvlOffset, 0, 5120, 720, null);
                    }
                    case 2 -> {
                        g.drawImage(section2Sprite, -xLvlOffset, 0, 5120, 720, null);

                        // DRAWING TILES (COMPLICATED ONE)
                        g.drawImage(TileManager.tiles[0].image, 631 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 681 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 731 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 781 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 831 - xLvlOffset, 311, 48, 48, null);
                    }
                }
                break;


            // Boss Fight
            case 4:
                g.setColor(Color.GRAY);
                g.fillRect(0, 0, 1280, 720);

                for (int i = 0; i < 27; i++) {
                    // Sides
                    g.drawImage(TileManager.tiles[2].image, 48 * (i) - xLvlOffset, 0, 48, 48, null);
                    g.drawImage(TileManager.tiles[2].image, -xLvlOffset, 48 * (i), 48, 48, null);
                    g.drawImage(TileManager.tiles[2].image, 1252 - xLvlOffset, 48 * (i), 48, 48, null);
                    // Ground
                    g.drawImage(TileManager.tiles[2].image, 48 * (i) - xLvlOffset, 528, 48, 48, null);
                    g.drawImage(TileManager.tiles[2].image, 48 * (i) - xLvlOffset, 528 + 48, 48, 48, null);
                    g.drawImage(TileManager.tiles[2].image, 48 * (i) - xLvlOffset, 528 + 48 + 48, 48, 48, null);
                    g.drawImage(TileManager.tiles[2].image, 48 * (i) - xLvlOffset, 528 + 48 + 48 + 48, 48, 48, null);
                    g.drawImage(TileManager.tiles[2].image, 48 * (i) - xLvlOffset, 528 + 48 + 48 + 48 + 48, 48, 48, null);
                }

                break;
        }


        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.BOLD, 60));
        g.drawString("Ghoole Marhale Akhar :D", 4300 - xLvlOffset, 350);

        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("Lives: " + lives, 20, 40);

        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("Coins: " + coins, 250, 40);

        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("Score: " + score, 500, 40);

        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.BOLD, 40));
        if ((-xLvlOffset <= 0) && (-xLvlOffset >= -1280))
            g.drawString("World: " + sectionNumber + " - 1", 1000, 40);
        else if ((-xLvlOffset <= -1280) && (-xLvlOffset >= -2560))
            g.drawString("World: " + sectionNumber + " - 2", 1000, 40);
        else if ((-xLvlOffset <= -2560) && (-xLvlOffset >= -3840))
            g.drawString("World: " + sectionNumber + " - 3", 1000, 40);
        else if ((-xLvlOffset <= 0))
            g.drawString("World: " + sectionNumber + " - 4", 1000, 40);

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public BufferedImage getSection1Sprite() {
        return section1Sprite;
    }

    public void setSection1Sprite(BufferedImage section1Sprite) {
        this.section1Sprite = section1Sprite;
    }

    public BufferedImage getSection2Sprite() {
        return section2Sprite;
    }

    public void setSection2Sprite(BufferedImage section2Sprite) {
        this.section2Sprite = section2Sprite;
    }
}
