package view.frames;

import config.Constants;
import model.Game;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSlotFrame extends JFrame {


    final JFrame frame;

    JLabel selectedChar;

    ButtonGroup btnGroup;
    JRadioButton pink;
    JRadioButton red;
    JRadioButton green;
    JRadioButton yellow;
    JRadioButton black;

    JButton backBtn;

    final JButton slot1;
    final JButton slot2;
    final JButton slot3;

    final JRadioButton easyBtn;
    final JRadioButton mediumBtn;
    final JRadioButton hardBtn;


    public GameSlotFrame() {

        backBtn = new JButton("BACK");
        backBtn.setBounds(15, 15, 80, 80);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainFrame();
            }
        });


        frame = new JFrame();

        slot1 = new JButton("Slot 1");
        slot1.setBounds(300, 180, 400, 120);
        slot1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Game game1 = new Game();
                User.loggedInUser.get(0).getGames().set(0, game1);
            }
        });


        slot2 = new JButton("Slot 2");
        slot2.setBounds(300, 360, 400, 120);
        slot2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Game game2 = new Game();
                User.loggedInUser.get(0).getGames().set(1, game2);
            }
        });


        slot3 = new JButton("Slot 3");
        slot3.setBounds(300, 540, 400, 120);
        slot3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Game game3 = new Game();
                User.loggedInUser.get(0).getGames().set(2, game3);
            }
        });


        selectedChar = new JLabel("Select Character: ");
        selectedChar.setFont(new Font("Courier", Font.PLAIN, 23));
        selectedChar.setBounds(50, 40, 300, 80);


        btnGroup = new ButtonGroup();

        pink = new JRadioButton("Pink");
        pink.setBounds(375, 55, 100, 40);
        pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.loggedInUser.get(0).setPinkChoose(true);
            }
        });

        black = new JRadioButton("Black");
        black.setBounds(480, 55, 100, 40);
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.loggedInUser.get(0).setBlackChoose(true);
            }
        });

        yellow = new JRadioButton("Yellow");
        yellow.setBounds(585, 55, 100, 40);
        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.loggedInUser.get(0).setYellowChoose(true);
            }
        });

        green = new JRadioButton("Green");
        green.setBounds(690, 55, 100, 40);
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.loggedInUser.get(0).setGreenChoose(true);
            }
        });

        red = new JRadioButton("Red");
        red.setBounds(795, 55, 100, 40);
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.loggedInUser.get(0).setRedChoose(true);
            }
        });


        btnGroup.add(pink);
        btnGroup.add(black);
        btnGroup.add(yellow);
        btnGroup.add(green);
        btnGroup.add(red);


        easyBtn = new JRadioButton("Easy");
        easyBtn.setBounds(250, 780, 100, 40);

        mediumBtn = new JRadioButton("Medium");
        mediumBtn.setBounds(450, 780, 100, 40);

        hardBtn = new JRadioButton("Hard");
        hardBtn.setBounds(650, 780, 100, 40);



        frame.setBackground(new Color(111, 28, 28));
        frame.setLayout(null);

        frame.add(slot1);
        frame.add(slot2);
        frame.add(slot3);
        frame.add(selectedChar);
        frame.add(backBtn);
        frame.add(pink);
        frame.add(green);
        frame.add(yellow);
        frame.add(black);
        frame.add(red);
        frame.add(easyBtn);
        frame.add(mediumBtn);
        frame.add(hardBtn);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Super Mario");
        frame.setSize(Constants.MENU_WIDTH, Constants.MENU_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}