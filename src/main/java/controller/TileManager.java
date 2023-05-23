package controller;

import config.ImageAddresses;
import model.Tile;
import view.GamePanel;

import java.awt.*;

public class TileManager {


    GamePanel gamePanel;
    public static Tile[] tile;

    public TileManager(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
        tile = new Tile[4];

        getTileImage();
    }


    public void getTileImage() {


        tile[0] = new Tile();
//            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("D:\\Coding Tutorial\\spam tamrin code\\SuperSuperMarioJackson\\src\\break.png")));
        tile[0].image = ImageAddresses.getPlayerSprite("break.png");

        tile[1] = new Tile();
//            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/MarioPhotos/prize_normal.png")));
        tile[1].image = ImageAddresses.getPlayerSprite("prize_normal.png");

    }


    public void draw(Graphics2D g2D) {
        g2D.drawImage(tile[0].image, 431, 311, 48, 48, null);
        g2D.drawImage(tile[0].image, 481, 311, 48, 48, null);
        g2D.drawImage(tile[1].image, 531, 311, 48, 48, null);
        g2D.drawImage(tile[0].image, 581, 311, 48, 48, null);
        g2D.drawImage(tile[0].image, 631, 311, 48, 48, null);
    }


}
