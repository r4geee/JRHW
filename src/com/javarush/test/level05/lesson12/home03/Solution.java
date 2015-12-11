package com.javarush.test.level05.lesson12.home03;

///* Создай классы Dog, Cat, Mouse
//Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
//Пример:
//Mouse jerryMouse = new Mouse(“Jerry”, 12/*высота, см*/ , 5 /*длина хвоста, см */)
//*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Cat tomCat = new Cat("Tom","grey", 666);
        Dog pesDog = new Dog("Pes","bulldog", 2);

        //Напишите тут ваш код
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //Напишите тут ваши классы
    public static class Cat
    {
        String name;
        String color;
        int evilness;

        public Cat(String name,String color, int evilness)
        {
            this.name = name;
            this.color = color;
            this.evilness = evilness;
        }
    }

    public static class Dog
    {
        String name;
        String breed;
        int frags;

        public Dog(String name, String breed, int frags)
        {
            this.name = name;
            this.breed = breed;
            this.frags = frags;
        }
    }

}
