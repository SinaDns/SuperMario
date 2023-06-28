package view.frames;

import config.Constants;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileFrame extends JFrame {

    JFrame frame;
    JButton backBtn;
    JLabel username;

    ImageIcon redMario;
    ImageIcon blackMario;
    ImageIcon yellowMario;
    ImageIcon greenMario;
    ImageIcon pinkMario;

    JLabel redLabel;
    JLabel blackLabel;
    JLabel yellowLabel;
    JLabel greenLabel;
    JLabel pinkLabel;

    JLabel scoreLabel;
    JLabel coinLabel;

    ProfileFrame() {


        redMario = new ImageIcon("src/StoreRed.png");
        blackMario = new ImageIcon("src/StoreBlack.png");
        yellowMario = new ImageIcon("src/StoreYellow.png");
        greenMario = new ImageIcon("src/StoreGreen.png");
        pinkMario = new ImageIcon("src/StorePink.png");

        backBtn = new JButton("BACK");
        backBtn.setBounds(15, 15, 80, 80);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainFrame();
            }
        });

        scoreLabel = new JLabel("Your HighScore is: " +  User.loggedInUser.get(0).getAllScores().get(0));
        scoreLabel.setFont(new Font("Courier", Font.PLAIN, 25));
        scoreLabel.setBounds(150, 320, 500, 100);

        coinLabel = new JLabel("Your Coins: " + User.loggedInUser.get(0).getUserCoins());
        coinLabel.setFont(new Font("Courier", Font.PLAIN, 25));
        coinLabel.setBounds(150, 500, 500, 100);


        redLabel = new JLabel("Here is our red label");
        blackLabel = new JLabel(blackMario);
        yellowLabel = new JLabel(yellowMario);
        greenLabel = new JLabel(greenMario);
        pinkLabel = new JLabel(pinkMario);

        username = new JLabel("Your Username: " + User.loggedInUser.get(0).getUsername());
        username.setFont(new Font("Courier", Font.PLAIN, 25));
        username.setBounds(150, 200, 450, 80);






        frame = new JFrame();
        frame.setLayout(null);

        frame.add(backBtn);
        frame.add(username);
        frame.add(scoreLabel);
        frame.add(coinLabel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Super Mario");
        frame.setSize(Constants.MENU_WIDTH, Constants.MENU_HEIGHT);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}



//  panel = new JPanel();
//        panel.setSize(Constants.MENUS_WIDTH, Constants.MENUS_HEIGHT);

// if (model.User.loggedInUser.get(0).blackBought && model.User.loggedInUser.get(0).blackChoose) {
//         blackLabel.setBounds(650, 450, 170, 250);
//         panel.add(blackLabel);
//         System.out.println("1 if");
//         }
//         if (model.User.loggedInUser.get(0).greenBought && model.User.loggedInUser.get(0).greenChoose) {
//         greenLabel.setBounds(650, 450, 170, 250);
//         panel.add(greenLabel);
//         System.out.println("2 if");
//         }
//         if (model.User.loggedInUser.get(0).redBought && model.User.loggedInUser.get(0).redChoose) {
//         redLabel.setBounds(650, 450, 200, 250);
//         panel.add(redLabel);
//         System.out.println("3 if");
//         }
//         if (model.User.loggedInUser.get(0).yellowBought && model.User.loggedInUser.get(0).yellowChoose) {
//         yellowLabel.setBounds(650, 450, 170, 250);
//         panel.add(yellowLabel);
//         System.out.println("3 if");
//         }
//         if (model.User.loggedInUser.get(0).pinkBought && model.User.loggedInUser.get(0).pinkChoose) {
//         pinkLabel.setBounds(650, 450, 170, 250);
//         panel.add(pinkLabel);
//         System.out.println("4 if");
//         }
