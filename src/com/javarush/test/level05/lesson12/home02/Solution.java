package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

import java.lang.management.ManagementFactory;

public class Solution
{
    public static void main(String[] args)
    {
        Man Vovka = new Man("Vladimir", 25, "Ulica Lenina 1");
        Woman Mashka = new Woman("Maria", 20, "Ulica Stalina 2");
        System.out.println(Vovka.name + " " + Vovka.age + " " + Vovka.address);
        System.out.println(Mashka.name + " " + Mashka.age + " " + Mashka.address);

        // Выведи их на экран тут
    }

    public static class Man
    {
        public String name;
        public int age;
        public String address = null;

        public Man(String name)
        {
            this.name = name;
        }

        public Man(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman
    {
        public String name;
        public int age;
        public String address = null;

        public Woman(String name)
        {
            this.name = name;
        }

        public Woman(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Woman(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
