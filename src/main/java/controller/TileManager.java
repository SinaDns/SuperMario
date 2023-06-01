package controller;

import config.ImageAddresses;
import model.Game;
import model.Tile;
import view.Drawable;
import view.GamePanel;

import java.awt.*;

public class TileManager implements Drawable {


    public static Tile[] tiles;
    GamePanel gamePanel;

    public TileManager(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
        tiles = new Tile[6];

        getTileImage();
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

//        g2D.drawImage(tiles[0].image, 431, 311, 48, 48, null);
//        g2D.drawImage(tiles[0].image, 481, 311, 48, 48, null);
//        g2D.drawImage(tiles[1].image, 531, 311, 48, 48, null);
//        g2D.drawImage(tiles[0].image, 581, 311, 48, 48, null);
//        g2D.drawImage(tiles[0].image, 631, 311, 48, 48, null);

        for (int i = 0; i < 33; i++)
            g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500, 48, 48, null);

        for (int i = 0; i < 33; i++)
            g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48, 48, 48, null);

        for (int i = 0; i < 33; i++)
            g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48, 48, 48, null);

        for (int i = 0; i < 33; i++)
            g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48, 48, 48, null);

        for (int i = 0; i < 33; i++)
            g.drawImage(tiles[2].image, 48 * (i) - xLvlOffset, 500 + 48 + 48 + 48 + 48, 48, 48, null);

        for (int i = 0; i < 66; i++)
            g.drawImage(tiles[2].image, 2000 + (48 * i) - xLvlOffset, 500 + 48 + 48, 48, 48, null);

        for (int i = 0; i < 5; i++)
            g.drawImage(tiles[1].image, 2000 + (48 * i) - xLvlOffset, 350, 48, 48, null);

        g.drawImage(tiles[5].image, 2000 - xLvlOffset, 350, 48, 48, null);


        // Drawing Slime Block
        if (Game.isInSectionOne)
            g.drawImage(tiles[4].image, 1000 - xLvlOffset, 430, 48, 48, null);

        if (Game.isInSectionTwo)
            g.drawImage(tiles[4].image, 1500 - xLvlOffset, 330, 48, 48, null);
    }
}
