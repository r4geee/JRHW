package com.javarush.test.level34.lesson15.big01.view;


import com.javarush.test.level34.lesson15.big01.model.Box;
import com.javarush.test.level34.lesson15.big01.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Field extends JPanel {

    private View view;

    public Field(View view) {
        this.view = view;
    }

    public void paint(Graphics g) {
        Box box = new Box(50, 50);
        box.draw(g);
        Player player = new Player(100, 100);
        player.draw(g);
    }
}
