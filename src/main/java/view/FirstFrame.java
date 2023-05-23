package view;

import config.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame implements ActionListener {

    final JFrame frame;
    final JButton createButton;
    final JButton loginButton;
    final JButton exitButton;


    public FirstFrame() {

        JLabel label = new JLabel("Please choose between these options:");
        label.setFont(new Font(null, Font.PLAIN, 35));

        createButton = new JButton("Create Account");
        createButton.addActionListener(this);
        createButton.setBounds(400, 200, 200, 40);
        createButton.setFocusable(false);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBounds(400, 300, 200, 40);
        loginButton.setFocusable(false);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setBounds(400, 400, 200, 40);
        exitButton.setFocusable(false);

        frame = new JFrame();
        frame.setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
        frame.add(label);
        frame.add(createButton);
        frame.add(loginButton);
        frame.add(exitButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Super Mario");
        frame.setSize(Constants.MENUS_WIDTH, Constants.MENUS_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == createButton) {
            frame.dispose();
            new CreateFrame();
        }

        if (e.getSource() == loginButton) {
            frame.dispose();
            new LoginFrame();
        }

        if (e.getSource() == exitButton) {
            System.exit(0);
        }

    }


}
