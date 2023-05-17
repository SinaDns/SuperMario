package view;

import javax.swing.*;

public class GameFrame extends JFrame {


    public GameFrame(GamePanel gamePanel) {


        this.setTitle("Super Mario");
        this.setFocusable(true);
        this.requestFocus();
        this.requestFocusInWindow();
        this.setBounds(0, 0, 1280, 720);
        this.add(gamePanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }


}
