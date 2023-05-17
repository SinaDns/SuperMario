package view;

import config.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    final JFrame frame;
    final JButton continueBtn;
    final JButton newgameBtn;
    final JButton profileBtn;
    final JButton storeBtn;
    final JButton leaderboardBtn;
    final JButton backBtn;


    public MainFrame() {
        backBtn = new JButton("BACK");
        backBtn.setBounds(15, 15, 80, 80);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new FirstFrame();
            }
        });


        newgameBtn = new JButton("New Game");
        newgameBtn.setBounds(425, 150, 150, 100);
        newgameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GameSlotFrame();
            }
        });


        continueBtn = new JButton("Continue Game");
        continueBtn.setBounds(425, 280, 150, 100);
        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ContinueFrame();
            }
        });


        profileBtn = new JButton("Your Profile");
        profileBtn.setBounds(425, 410, 150, 100);
        profileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ProfileFrame();
            }
        });


        storeBtn = new JButton("Store");
        storeBtn.setBounds(425, 540, 150, 100);
        storeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new StoreFrame();
            }
        });


        leaderboardBtn = new JButton("LeaderBoard");
        leaderboardBtn.setBounds(425, 680, 150, 100);
        leaderboardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LeaderBoardFrame();
            }
        });




        frame = new JFrame();
        frame.setBackground(Color.DARK_GRAY);
        frame.setLayout(null);

        frame.add(backBtn);
        frame.add(newgameBtn);
        frame.add(continueBtn);
        frame.add(profileBtn);
        frame.add(storeBtn);
        frame.add(leaderboardBtn);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Super Mario");
        frame.setSize(Constants.MENUS_WIDTH, Constants.MENUS_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
