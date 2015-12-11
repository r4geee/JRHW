package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Alexei on 18.01.2015.
 */
public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Waitor waitor = new Waitor();

        Cook cookOne = new Cook("CookOne");
        cookOne.setQueue(QUEUE);
        cookOne.addObserver(waitor);
        Thread cookOneThread = new Thread(cookOne);
        cookOneThread.setDaemon(true);
        cookOneThread.start();

        Cook cookTwo = new Cook("CookTwo");
        cookTwo.setQueue(QUEUE);
        cookTwo.addObserver(waitor);
        Thread cookTwoThread = new Thread(cookTwo);
        cookTwoThread.setDaemon(true);
        cookTwoThread.start();

        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet newTablet = new Tablet(i);
            newTablet.setQueue(QUEUE);
            tabletList.add(newTablet);
        }

        Thread producerThread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        producerThread.start();

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {

        }
        if (!producerThread.isInterrupted()) {
            producerThread.interrupt();
        }
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {

        }
        if (!cookOneThread.isInterrupted()) {
            cookOneThread.interrupt();
        }
        if (!cookTwoThread.isInterrupted()) {
            cookTwoThread.interrupt();
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
