package com.javarush.test.level34.lesson15.big01.view;


import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.Box;
import com.javarush.test.level34.lesson15.big01.model.Home;
import com.javarush.test.level34.lesson15.big01.model.Player;
import com.javarush.test.level34.lesson15.big01.model.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Field extends JPanel {

    EventListener eventListener;
    private View view;

    public Field(View view) {
        this.view = view;
    }

    public void paint(Graphics g) {
        Box box = new Box(50, 50);
        box.draw(g);
        Player player = new Player(100, 100);
        player.draw(g);
        Home home = new Home(100, 100);
        home.draw(g);
        Wall wall = new Wall(150, 100);
        wall.draw(g);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
