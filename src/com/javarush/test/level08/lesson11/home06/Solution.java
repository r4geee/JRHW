package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1 = new Human("Petja", true, 15, null);
        Human child2 = new Human("Vova", true, 10, null);
        Human child3 = new Human("Marfa", false, 12, null);
        ArrayList<Human> tempListChildren = new ArrayList<Human>();
        Collections.addAll(tempListChildren, child1, child2, child3);
        Human papa = new Human("Georgij", true, 41, tempListChildren);
        Human mama = new Human("Elena", false, 36, tempListChildren);
        ArrayList<Human> tempListPapa = new ArrayList<Human>();
        tempListPapa.add(papa);
        Human ded1 = new Human("Vassilij", true, 80, tempListPapa);
        Human babka1 = new Human("Galina", false, 76, tempListPapa);
        ArrayList<Human> tempListMama = new ArrayList<Human>();
        tempListMama.add(mama);
        Human ded2 = new Human("Gogi", true, 88, tempListMama);
        Human babka2 = new Human("Vera", false, 70, tempListMama);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(ded1);
        System.out.println(babka1);
        System.out.println(ded2);
        System.out.println(babka2);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human (String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = 0;
            if (this.children != null)
                childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
