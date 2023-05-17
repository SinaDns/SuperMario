package view;

import config.Constants;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreFrame extends JFrame {


    JFrame frame;
    JPanel panel;

    ImageIcon redMario;
    ImageIcon blackMario;
    ImageIcon yellowMario;
    ImageIcon greenMario;
    ImageIcon pinkMario;

    JButton backBtn;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;

    JButton redButton;
    JButton blackButton;
    JButton yellowButton;
    JButton greenButton;
    JButton pinkButton;


    StoreFrame() {

        backBtn = new JButton("BACK");
        backBtn.setBounds(15, 15, 80, 80);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainFrame();
            }
        });

//        redMario = new ImageIcon("src/StoreRed.png");
//        blackMario = new ImageIcon("src/StoreBlack.png");
//        yellowMario = new ImageIcon("src/StoreYellow.png");
//        greenMario = new ImageIcon("src/StoreGreen.png");
//        pinkMario = new ImageIcon("src/StorePink.png");
        redMario = new ImageIcon("src/main/java/StoreRed.png");
        blackMario = new ImageIcon("src/main/java/StoreBlack.png");
        yellowMario = new ImageIcon("src/main/java/StoreYellow.png");
        greenMario = new ImageIcon("src/main/java/StoreGreen.png");
        pinkMario = new ImageIcon("src/main/java/StorePink.png");

        panel = new JPanel();
        panel.setBounds(0, 0, Constants.MENUS_WIDTH, Constants.MENUS_HEIGHT);


        label1 = new JLabel(redMario);
        label1.setBounds(20, 300, 170, 250);

        label2 = new JLabel(blackMario);
        label2.setBounds(220, 300, 170, 250);

        label3 = new JLabel(yellowMario);
        label3.setBounds(420, 300, 170, 250);

        label4 = new JLabel(greenMario);
        label4.setBounds(620, 300, 170, 250);

        label5 = new JLabel(pinkMario);
        label5.setBounds(820, 300, 170, 250);


        redButton = new JButton("Buy");
        redButton.setBounds(50, 500, 100, 100);
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.loggedInUser.get(0).getUserCoins().get(0) >= 0) {
                    redButton.setBackground(new Color(63, 163, 30, 145));
                    redButton.setText("Bought");
                    User.loggedInUser.get(0).getUserCoins().set(0, User.loggedInUser.get(0).getUserCoins().get(0));
                    User.loggedInUser.get(0).setRedBought(true);
                }
            }
        });


        blackButton = new JButton("Buy");
        blackButton.setBounds(250, 500, 100, 100);
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.loggedInUser.get(0).getUserCoins().get(0) >= 8) {
                    blackButton.setBackground(new Color(63, 163, 30, 145));
                    blackButton.setText("Bought");
                    User.loggedInUser.get(0).getUserCoins().set(0, User.loggedInUser.get(0).getUserCoins().get(0) - 8);
                    User.loggedInUser.get(0).setBlackBought(true);
                }
            }
        });

        yellowButton = new JButton("Buy");
        yellowButton.setBounds(450, 500, 100, 100);
        yellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.loggedInUser.get(0).getUserCoins().get(0) >= 3) {
                    yellowButton.setBackground(new Color(63, 163, 30, 145));
                    yellowButton.setText("Bought");
                    User.loggedInUser.get(0).getUserCoins().set(0, User.loggedInUser.get(0).getUserCoins().get(0) - 3);
                    User.loggedInUser.get(0).setYellowBought(true);
                }
            }
        });


        greenButton = new JButton("Buy");
        greenButton.setBounds(650, 500, 100, 100);
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (User.loggedInUser.get(0).getUserCoins().get(0) >= 5) {
                    greenButton.setBackground(new Color(63, 163, 30, 145));
                    greenButton.setText("Bought");
                    User.loggedInUser.get(0).getUserCoins().set(0, User.loggedInUser.get(0).getUserCoins().get(0) - 5);
                    User.loggedInUser.get(0).setGreenBought(true);
                }

            }
        });


        pinkButton = new JButton("Buy");
        pinkButton.setBounds(850, 500, 100, 100);
        pinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (User.loggedInUser.get(0).getUserCoins().get(0) >= 2) {
                    pinkButton.setBackground(new Color(63, 163, 30, 145));
                    pinkButton.setText("Bought");
                    User.loggedInUser.get(0).getUserCoins().set(0, User.loggedInUser.get(0).getUserCoins().get(0) - 2);
                    User.loggedInUser.get(0).setPinkBought(true);
                }

            }
        });

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);



        frame = new JFrame();
        frame.add(redButton);
        frame.add(blackButton);
        frame.add(yellowButton);
        frame.add(greenButton);
        frame.add(pinkButton);
        frame.add(backBtn);
        frame.add(panel);
        frame.setLayout(null);
//        frame.setIconImage(new ImageIcon(config.ImageAddresses.ICON_GAME).getImage());
        frame.setTitle("Super Mario");
        frame.setSize(Constants.MENUS_WIDTH, Constants.MENUS_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
