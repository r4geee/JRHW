package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alexei on 18.01.2015.
 */
public class Order {
    private Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty())
            return "";
        else
            return "Your order: " + dishes + " of " + tablet;
    }

    public boolean isEmpty() {
        return dishes == null || dishes.isEmpty();
    }

    public int getTotalCookingTime() {
        int result = 0;
        if (isEmpty()) {
            return result;
        } else {
            for (Dish dish : dishes) {
                result += dish.getDuration();
            }
            return result;
        }
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }
}
