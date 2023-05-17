package view;

import config.Constants;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class LeaderBoardFrame extends JFrame {


    JFrame frame;
    JButton backBtn;
    JScrollPane scrollPane;
    String[][] data = new String[50][2];
    String[] header = new String[]{"model.Player Name", "High Score"};
    JTable table;

    LeaderBoardFrame() {

        backBtn = new JButton("BACK");
        backBtn.setBounds(15, 15, 80, 80);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainFrame();
            }
        });

        table = new JTable(data, header);
        table.setBounds(0, 0, Constants.MENUS_WIDTH, Constants.MENUS_HEIGHT);
        table.setFont(new Font("Courier", Font.PLAIN, 40));
        table.setRowHeight(80);

        for (int i = 0; i < User.users.size(); i++)
            table.setValueAt(User.users.get(i).getUsername(), i, 0);


        for (int i = 0; i < User.users.get(i).getAllScores().size(); i++) {
            Collections.sort(User.users.get(i).getAllScores());
            Collections.reverse(User.users.get(i).getAllScores());
        }


        for (int i = 0; i < User.users.size(); i++)
            table.setValueAt(String.valueOf(User.users.get(i).getAllScores().get(0)), i, 1);


        scrollPane = new JScrollPane(table);
        scrollPane.add(backBtn);
        scrollPane.setBounds(950, 105, 30, 400);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame = new JFrame();
        frame.setTitle("ScoreBoard List");
        frame.setSize(Constants.MENUS_WIDTH, Constants.MENUS_HEIGHT);
        frame.setResizable(false);
        frame.add(scrollPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
