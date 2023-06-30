package model.enemies;

import controller.LevelManager;
import model.others.Bomb;
import model.interfaces.Moveable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NukeBird extends Enemy implements Moveable {

    public int x;
    public int y;
    public int width = 57;
    public int height = 100;
    public boolean isOk = false;
    LevelManager levelManager;
    Bomb bomb;
    float nukebirdSpeed = -1f;

    public NukeBird(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        this.x = x;
        this.y = y;
        this.levelManager = levelManager;
    }

    @Override
    public void move() {

        x += nukebirdSpeed;
        this.setLocation(x, y);

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