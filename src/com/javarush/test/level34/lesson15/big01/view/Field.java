package com.javarush.test.level34.lesson15.big01.view;


import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.*;
import com.javarush.test.level34.lesson15.big01.model.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Field extends JPanel {

    EventListener eventListener;
    private View view;

    public Field(View view) {
        this.view = view;
    }

    public void paint(Graphics graphics) {
//        Box box = new Box(50, 50);
//        box.draw(graphics);
//        Player player = new Player(100, 100);
//        player.draw(graphics);
//        Home home = new Home(100, 100);
//        home.draw(graphics);
//        Wall wall = new Wall(150, 100);
//        wall.draw(graphics);
        graphics.setColor(Color.BLACK);
        //graphics.drawRect(0, 0, getWidth(), getHeight());
        graphics.fillRect(0, 0, getWidth(), getHeight());
        for(GameObject gameObject : view.getGameObjects().getAll()) {
            gameObject.draw(graphics);
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
