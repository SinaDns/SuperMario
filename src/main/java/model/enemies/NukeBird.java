package model.enemies;

import controller.LevelManager;
import model.Bomb;
import model.interfaces.Moveable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NukeBird implements Moveable {

    public boolean isOk = false;
    public int x = 2500;
    public int y = 70;
    public int width = 57;
    public int height = 100;
    LevelManager levelManager;
    Bomb bomb;
    float nukebirdSpeed = -1f;

    public NukeBird(LevelManager levelManager, Bomb bomb) {
        this.bomb = bomb;
        this.levelManager = levelManager;
    }

    @Override
    public void move() {

        x += nukebirdSpeed;


        if (isOk) {
            bomb.x = NukeBird.this.x;
            bomb.isBombReleased = true;
        }


        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        timer.start();
        timer.setRepeats(true);
    }

}