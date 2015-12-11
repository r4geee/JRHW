package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Test on 04.08.2015.
 */
public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        List<Dish> randomDishes = new ArrayList<>();
        int random;
        for (Dish dish : Dish.values()) {
            //random = (int) (Math.random() * 2);
            random = ThreadLocalRandom.current().nextInt(2);
            if (random == 1) {
                randomDishes.add(dish);
            }
        }
        dishes = randomDishes;
    }
}
