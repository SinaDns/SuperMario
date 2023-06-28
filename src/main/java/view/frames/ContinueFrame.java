package view.frames;

import config.Constants;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContinueFrame extends JFrame {

    final JFrame frame;

    JButton backBtn;
    final JButton slot1;
    final JButton slot2;
    final JButton slot3;


    ContinueFrame() {

        backBtn = new JButton("BACK");
        backBtn.setBounds(15, 15, 80, 80);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainFrame();
            }
        });




        slot1 = new JButton("model.Game 1");
        slot1.setBounds(300, 180, 400, 120);
          slot1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                User.loggedInUser.get(0).getGames().get(0).showPanel();
            }
        });

        slot2 = new JButton("model.Game 2");
        slot2.setBounds(300, 360, 400, 120);
        slot2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                User.loggedInUser.get(0).getGames().get(1).showPanel();            }
        });

        slot3 = new JButton("model.Game 3");
        slot3.setBounds(300, 540, 400, 120);
        slot3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slot1.setText("model.Game 3");
                frame.dispose();
                User.loggedInUser.get(0).getGames().get(2).showPanel();            }
        });


        frame = new JFrame();

        frame.setBackground(new Color(111, 28, 28));
        frame.setLayout(null);
        frame.add(backBtn);
        frame.add(slot1);
        frame.add(slot2);
        frame.add(slot3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Super Mario");
        frame.setSize(Constants.MENU_WIDTH, Constants.MENU_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}