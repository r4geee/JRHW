package com.javarush.test.level05.lesson05.task05;

/* Провести три боя  попарно между котами
Создать три кота используя класс Cat.
Провести три боя попарно между котами.
Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
Результат каждого боя вывести на экран.
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        Cat cat1 = new Cat("Murzik",5,25,7);
        Cat cat2 = new Cat("Vaska",4,15,3);
        Cat cat3 = new Cat("Barsik",3,15,5);

        boolean fight1 = cat1.fight(cat2);
        String result1 = "losses to ";
        if (fight1)
            result1 = "Wins ";
        System.out.println(cat1.name + " " + result1 + cat2.name);

        boolean fight2 = cat1.fight(cat3);
        String result2 = "losses to ";
        if (fight2)
            result2 = "Wins ";
        System.out.println(cat1.name + " " + result2 + cat3.name);

        boolean fight3 = cat2.fight(cat3);
        String result3 = "losses to ";
        if (fight3)
            result3 = "Wins ";
        System.out.println(cat2.name + " " + result3 + cat3.name);
    }

    public static class Cat {

        public static int count = 0;
        public static int fightCount = 0;

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            fightCount++;

            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; //эквивалентно return score > 2 ? true : false;
        }
    }
}
