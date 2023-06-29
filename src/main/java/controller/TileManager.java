package controller;

import config.ImageAddresses;
import model.Game;
import model.Tile;
import view.Drawable;
import view.panels.GamePanel;

import java.awt.*;

public class TileManager implements Drawable {


    public static Tile[] tiles;
    public LevelManager levelManager;
    GamePanel gamePanel;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tiles = new Tile[6];

        getTileImage();
    }

    public TileManager(LevelManager levelManager) {
        this.levelManager = levelManager;
    }


    public void getTileImage() {
        tiles[0] = new Tile();
        tiles[0].image = ImageAddresses.getSprite("break.png");

        tiles[1] = new Tile();
        tiles[1].image = ImageAddresses.getSprite("prize_normal.png");

        tiles[2] = new Tile();
        tiles[2].image = ImageAddresses.getSprite("FilledBlock.png");

        tiles[3] = new Tile();
        tiles[3].image = ImageAddresses.getSprite("SimpleBlock.png");

        tiles[4] = new Tile();
        tiles[4].image = ImageAddresses.getSprite("Slime.png");

        tiles[5] = new Tile();
        tiles[5].image = ImageAddresses.getSprite("QuestionMarkBlock.png");
    }

    @Override
    public void draw(Graphics g, int xLvlOffset) {


        for (int i = 0; i < 134; i++) {
            g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500, 48, 48, null);
            g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48, 48, 48, null);
            g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48, 48, 48, null);
            g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48, 48, 48, null);
            g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48 + 48, 48, 48, null);
        }

        /* ------------------------------------- Drawing All Level 1 Tiles ------------------------------------------ */
        if (Game.isInLevelOne && Game.isInSectionOne) {
//            for (int i = 0; i < 39; i++) {
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48 + 48, 48, 48, null);
//            }
//
//            for (int i = 0; i < 100; i++) {
//                g.drawImage(tiles[2].image, 2040 + 48 * (i) - xLvlOffset, 500, 48, 48, null);
//                g.drawImage(tiles[2].image, 2040 + 48 * (i) - xLvlOffset, 500 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 2040 + 48 * (i) - xLvlOffset, 500 + 48 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 2040 + 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 2040 + 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48 + 48, 48, 48, null);
//            }
            g.drawImage(tiles[2].image, 5000 - xLvlOffset, 400, 48, 48, null);

            for (int i = 0; i < 5; i++)
                g.drawImage(tiles[1].image, (2200 + (48 * i) ) + (20 * i)  - xLvlOffset, 300, 48, 48, null);

            g.drawImage(tiles[5].image, 2200 - xLvlOffset, 300, 48, 48, null);


            // SLIME TILE
            g.drawImage(tiles[4].image, 1000 - xLvlOffset, 430, 48, 48, null);
        }

        if (Game.isInLevelOne && Game.isInSectionTwo) {
//            for (int i = 0; i < 70; i++) {
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48 + 48, 48, 48, null);
//            }

            g.drawImage(tiles[2].image, 4000 - xLvlOffset, 400, 48, 48, null);

            for (int i = 0; i < 2; i++) {
                g.drawImage(tiles[1].image, 2800 + (48 * i) - xLvlOffset, 350, 48, 48, null);
                g.drawImage(tiles[1].image, 2944 + (48 * i) - xLvlOffset, 350, 48, 48, null);
            }
            g.drawImage(tiles[5].image, 2896 - xLvlOffset, 350, 48, 48, null);


            // SLIME TILE
            g.drawImage(tiles[4].image, 2000 - xLvlOffset, 430, 48, 48, null);
        }
        /* ---------------------------------------------------------------------------------------------------------- */

        /* ------------------------------------- Drawing All Level 2 Tiles ------------------------------------------ */

        if (Game.isInLevelTwo && Game.isInSectionOne) {
//            for (int i = 0; i < 50; i++) {
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48 + 48, 48, 48, null);
//            }


        }

        if (Game.isInLevelTwo && Game.isInSectionTwo) {
//            for (int i = 0; i < 150; i++) {
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48, 48, 48, null);
//                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48 + 48, 48, 48, null);
//            }



        }

        /* ---------------------------------------------------------------------------------------------------------- */


//        if (Game.isInBossFight) {
//            for (int i = 0; i < 27; i++) {
//                g.drawImage(tiles[1].image, (48 * i) - xLvlOffset, 0, 48, 48, null);
//            }
//        }

        if (Game.isInFirstHiddenPart) {
            for (int i = 0; i < 39; i++) {
                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500, 48, 48, null);
                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48, 48, 48, null);
                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48, 48, 48, null);
                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48, 48, 48, null);
                g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48 + 48, 48, 48, null);
            }
        }


    }
}
