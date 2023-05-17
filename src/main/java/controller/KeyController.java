package controller;

import view.GamePanel;
import view.MainFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyController implements KeyListener {


    private final GamePanel gamePanel;


    public KeyController(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gamePanel.getGame().getPlayer().setLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getPlayer().setRight(true);
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.getGame().getPlayer().setJumping(true);
                break;
            case KeyEvent.VK_P:
                System.out.println("pause");
                break;
            case KeyEvent.VK_ESCAPE:
                System.out.println("escape");
                gamePanel.getGame().getFrames().get(0).dispose();
                gamePanel.getGame().stopTimer();
                new MainFrame();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gamePanel.getGame().getPlayer().setLeft(false);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getPlayer().setRight(false);
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.getGame().getPlayer().setJumping(false);
                break;
        }

    }


}
