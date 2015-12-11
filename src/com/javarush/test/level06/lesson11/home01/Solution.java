package com.javarush.test.level06.lesson11.home01;

/* Класс Cat и статическая переменная catCount
В классе Cat создай статическую переменную public int catCount.
Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat) статическая переменная
catCount увеличивается на 1. Создать 10 объектов Cat и вывести значение переменной catCount на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Cat topCat1 = new Cat();
        Cat topCat2 = new Cat();
        Cat topCat3 = new Cat();
        Cat topCat4 = new Cat();
        Cat topCat5 = new Cat();
        Cat topCat6 = new Cat();
        Cat topCat7 = new Cat();
        Cat topCat8 = new Cat();
        Cat topCat9 = new Cat();
        Cat topCat10 = new Cat();

        System.out.print(Cat.catCount);

        // Выведи на экран catCount тут
    }

    public static class Cat
    {
        static int catCount;

        public Cat()
        {
            Cat.catCount++;
        }

        //создай конструктор тут
    }

}
