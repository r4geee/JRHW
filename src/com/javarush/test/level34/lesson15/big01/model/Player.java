package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Player extends CollisionObject implements Movable{
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(Color.YELLOW);
        Ellipse2D.Float aFloat = new Ellipse2D.Float(getX(), getY(), getWidth(), getHeight());
        g2.fill(aFloat);
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}
