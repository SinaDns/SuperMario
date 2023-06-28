package view.panels;

import config.Constants;
import controller.TileManager;
import model.Game;
import view.KeyController;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {

    Game game;
    TileManager tileM = new TileManager(this);

    public GamePanel(Game game) {
//        this.setBackground(new Color(86, 126, 144));
        this.game = game;

        setPanelSize();
        addKeyListener(new KeyController(this));
    }

    void setPanelSize() {
        Dimension size = new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("size: " + Constants.GAME_WIDTH + " / " + Constants.GAME_HEIGHT);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        // one more sprite of mario
//        g.drawImage(new ImageIcon(config.ImageAddresses.CHARACTER3).getImage(), 200, 200, 50, 80, this);


//        g.setColor(new Color(74, 42, 23));
//        g.fillRect(400, 320, 48, 48);
//
//        g.setColor(new Color(74, 42, 23));
//        g.fillRect(450, 320, 48, 48);
//
//        g.setColor(new Color(74, 42, 23));
//        g.fillRect(500, 320, 48, 48);
//
//        g.setColor(new Color(74, 42, 23));
//        g.fillRect(550, 320, 48, 48);

//        g.setColor(new Color(113, 63, 27));
//        g.fillRect(0, 500, 2000, 300);

//        tileM.draw((Graphics2D) g);

        // this should be the latest thing in paintComponent method.
        game.render(g);
    }


    public Game getGame() {
        return game;
    }
}
