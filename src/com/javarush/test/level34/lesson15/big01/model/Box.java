package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Box  extends CollisionObject implements Movable{
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(Color.ORANGE);
        g2.draw(new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight()));
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}