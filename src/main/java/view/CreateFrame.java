package view;

import config.Constants;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFrame extends JFrame {

    final JFrame frame;
    final JLabel usernameTextLabel;
    final JLabel passwordTextLabel;
    final JTextField usernameField;
    final JTextField passwordField;

    final JButton submitButton;
    final JButton backBtn;

    public CreateFrame() {

        backBtn = new JButton("BACK");
        backBtn.setBounds(15, 15, 80, 80);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new FirstFrame();
            }
        });


        usernameField = new JTextField();
        usernameField.setBounds(450, 300, 300, 70);

        passwordField = new JTextField();
        passwordField.setBounds(450, 600, 300, 70);

        usernameTextLabel = new JLabel("Enter your username:");
        usernameTextLabel.setBounds(250, 270, 300, 100);

        passwordTextLabel = new JLabel("Enter your password:");
        passwordTextLabel.setBounds(250, 570, 300, 100);

        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(350, 750, 300, 50);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.checkUsername(usernameField.getText())) {
                    new User(usernameField.getText(), passwordField.getText());
                    frame.dispose();
                    new FirstFrame();
                }
                else {
                    frame.dispose();
                    new CreateFrame();
                }
            }
        });


        frame = new JFrame();
        frame.add(usernameTextLabel);
        frame.add(passwordTextLabel);
        frame.add(usernameField);
        frame.add(passwordField);
        frame.add(submitButton);
        frame.add(backBtn);
        frame.setLayout(null);
        frame.setTitle("Super Mario");
        frame.setSize(Constants.MENUS_WIDTH, Constants.MENUS_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



}
