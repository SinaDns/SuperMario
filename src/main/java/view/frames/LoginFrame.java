package view.frames;

import config.Constants;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    final JFrame frame;
    final JButton backBtn;
    final JButton loginBtn;
    final JTextField usernameField;
    final JTextField passwordField;
    final JLabel usernameText;
    final JLabel passwordText;


    LoginFrame() {

        backBtn = new JButton("BACK");
        backBtn.setBounds(15, 15, 80, 80);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new FirstFrame();
            }
        });

        usernameText = new JLabel();
        usernameText.setText("Username:");
        usernameText.setBounds(200, 200, 100, 50);

        passwordText = new JLabel();
        passwordText.setText("Password:");
        passwordText.setBounds(200, 400, 100, 50);


        usernameField = new JTextField();
        usernameField.setBounds(300, 150, 400, 100);
        usernameField.setFont(new Font("Consolas", Font.PLAIN, 30));

        passwordField = new JTextField();
        passwordField.setBounds(300, 350, 400, 100);
        passwordField.setFont(new Font("Consolas", Font.PLAIN, 30));

        loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(400, 750, 200, 60);
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginBtn) {
                    User.login(usernameField.getText(), passwordField.getText());
                    frame.dispose();
                    new MainFrame();
                }
            }
        });


        frame = new JFrame();
        frame.add(backBtn);
        frame.add(loginBtn);
        frame.add(usernameText);
        frame.add(passwordText);
        frame.add(usernameField);
        frame.add(passwordField);
        frame.setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
//        frame.setIconImage(new ImageIcon(config.ImageAddresses.ICON_GAME).getImage());
        frame.setTitle("Super Mario");
        frame.setSize(Constants.MENU_WIDTH, Constants.MENU_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
