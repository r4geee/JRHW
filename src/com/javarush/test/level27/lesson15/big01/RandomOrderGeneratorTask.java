package com.javarush.test.level27.lesson15.big01;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Test on 04.08.2015.
 */
public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.interval = interval;
        this.tablets = tablets;
    }

    @Override
    public void run() {
        if (tablets.isEmpty())
            return;
        while (!Thread.currentThread().isInterrupted()) {
            Tablet tablet = tablets.get((ThreadLocalRandom.current().nextInt(tablets.size())));
            tablet.createTestOrder();
            try {
                Thread.sleep(interval);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

