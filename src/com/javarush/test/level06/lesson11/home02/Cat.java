package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {

    public static ArrayList<Cat> cats = new ArrayList<Cat>();
    String name;

    public Cat(String name)
    {
        this.name = name;
        cats.add(this);

    }
    //add your code here - добавь свой код тут

    public static void main(String[] args) {

        String catName;
        for (int i = 0;i <10;i++)
        {
            catName = "Kotan " + (i+1);
            Cat cat1 = new Cat(catName);
        }

        /*
        Cat topCat1 = new Cat("topCat1");
        Cat topCat2 = new Cat("topCat2");
        Cat topCat3 = new Cat("topCat3");
        Cat topCat4 = new Cat("topCat4");
        Cat topCat5 = new Cat("topCat5");
        Cat topCat6 = new Cat("topCat61");
        Cat topCat7 = new Cat("topCat7");
        Cat topCat8 = new Cat("topCat8");
        Cat topCat9 = new Cat("topCat9");
        Cat topCat10 = new Cat("topCat10");
        */
            printCats();
    }

    public static void printCats() {
        //add your step 3 code here - добавь свой код для пункта 3 тут

        /*
        for (int i = 0;i<10;i++);
        {
            System.out.println(cats);
        }
        */


        for(int i=0;i<cats.size();i++)
        {
            System.out.println(cats.get(i));
        }
    }
}
