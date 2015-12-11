package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.Objects;

public class Solution
{
    public static void main(String[] args)
    {
        Human ded1 = new Human("Вася", true, 70, null, null);
        Human ded2 = new Human("Петя", true, 75, null, null);
        Human babka1 = new Human("Люба", false, 63, null, null);
        Human babka2 = new Human("Фая", false, 67, null, null);
        Human batja = new Human("Сергей", true, 45, ded1, babka1);
        Human mamka = new Human("Галя", false, 42, ded2, babka2);
        Human kid1 = new Human("Марина", false, 20, batja, mamka);
        Human kid2 = new Human("Вова", true, 18, batja, mamka);
        Human kid3 = new Human("Света", false, 15, batja, mamka);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(babka1);
        System.out.println(babka2);
        System.out.println(batja);
        System.out.println(mamka);
        System.out.println(kid1);
        System.out.println(kid2);
        System.out.println(kid3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;



        public Human(String  name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
