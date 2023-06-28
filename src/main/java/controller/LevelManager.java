package controller;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import config.Constants;
import config.ImageAddresses;
import model.Game;
import model.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {

    public int levelNumber;
    public int sectionNumber;

    public Player player;
    private Game game;



    public LevelManager(Game game, int levelNumber, int sectionNumber) {
        this.game = game;
        this.sectionNumber = sectionNumber;
        this.levelNumber = levelNumber;
    }

    public LevelManager(Player player) {
        this.player = player;
    }

    public LevelManager() {

    }


    public void draw(Graphics g, int xLvlOffset, int lives, int coins, int score) {

        switch (levelNumber) {

            case 1:
                g.setColor(new Color(75, 145, 233, 255));
                g.fillRect(0, 0, 5* Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
                switch (sectionNumber) {
                    case 1 -> {
                        // Hole
                        g.setColor(new Color(7, 50, 96, 255));
                        g.fillRect(1950, 300, 90, 300);
                    }
                    case 2 -> {
                        g.drawImage(TileManager.tiles[0].image, 631 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 681 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 731 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 781 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 831 - xLvlOffset, 311, 48, 48, null);
                    }
                }
                break;

            case 2:
                g.setColor(new Color(90, 51, 148, 224));
                g.fillRect(0, 0, 5* Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
                switch (sectionNumber) {
                    case 1 -> {

                    }
                    case 2 -> {
                        // DRAWING TILES (COMPLICATED ONE)
                        g.drawImage(TileManager.tiles[0].image, 631 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 681 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 731 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 781 - xLvlOffset, 311, 48, 48, null);
                        g.drawImage(TileManager.tiles[0].image, 831 - xLvlOffset, 311, 48, 48, null);
                    }
                }
                break;

            case 3:
                g.setColor(new Color(29, 81, 58));
                g.fillRect(0, 0, 6400, 720);
                switch (sectionNumber) {
                    case 1 -> {}
                    case 2 -> {}
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


            case 5:
                g.setColor(new Color(113, 68, 68));
                g.fillRect(0, 0, 1280, 720);
                break;
        }
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
}
