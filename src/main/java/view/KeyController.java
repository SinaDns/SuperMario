package view;

import view.frames.MainFrame;
import view.panels.GamePanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyController implements KeyListener {

    private final GamePanel gamePanel;
    public Timer timer;

    public KeyController(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> gamePanel.getGame().getPlayer().setLeft(true);
            case KeyEvent.VK_RIGHT -> gamePanel.getGame().getPlayer().setRight(true);
            case KeyEvent.VK_SPACE -> gamePanel.getGame().getPlayer().setJumping(true);
            case KeyEvent.VK_F -> {
                gamePanel.getGame().getPlayer().setFire(true);
            }
            case KeyEvent.VK_P -> {
                System.out.println("pause");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            case KeyEvent.VK_C -> {
                System.out.println("Mario neshast");
                gamePanel.getGame().getPlayer().isOnMiniMode = !gamePanel.getGame().getPlayer().isOnMiniMode;
            }
            case KeyEvent.VK_ESCAPE -> {
                System.out.println("escape");
                gamePanel.getGame().getFrames().get(0).dispose();
                gamePanel.getGame().stopTimer();
                new MainFrame();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> gamePanel.getGame().getPlayer().setLeft(false);
            case KeyEvent.VK_RIGHT -> gamePanel.getGame().getPlayer().setRight(false);
            case KeyEvent.VK_SPACE -> gamePanel.getGame().getPlayer().setJumping(false);
            case KeyEvent.VK_F -> {
                gamePanel.getGame().fireball.setX = true;
            }
            case KeyEvent.VK_P -> {
                Thread.currentThread().resume();
            }
        }
    }
}
