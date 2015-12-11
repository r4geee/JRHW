package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        String clan;
        int level;
        String league;

        public Human()
        {
            this.name = "unknown";
        }

        public Human (String name)
        {
            this.name = name;
        }

        public Human (String name, boolean sex )
        {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, String clan)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.clan = clan;
        }

        public Human(String name, boolean sex, int age, String clan, int level)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.clan = clan;
            this.level = level;
        }

        public Human(String name, boolean sex, int age, String clan, int level, String league)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.clan = clan;
            this.level = level;
            this.league = league;
        }

        public Human(String name, int age, String clan, int level, String league)
        {
            this.name = name;
            this.age = age;
            this.clan = clan;
            this.level = level;
            this.league = league;
        }

        public Human(String name, String clan, int level, String league)
        {
            this.name = name;
            this.clan = clan;
            this.level = level;
            this.league = league;
        }

        public Human(String name, int level, int age)
        {
            this.name = name;
            this.level = level;
            this.age = age;
        }
    }
}
