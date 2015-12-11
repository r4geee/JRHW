package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String grFatherName = reader.readLine();
        Cat catGrFather = new Cat(grFatherName);

        String grMotherName = reader.readLine();
        Cat catGrMother = new Cat(grMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, catGrFather, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, catGrMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catFather, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather, catMother);



        System.out.println(catGrFather);
        System.out.println(catGrMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat parent1 = null;
        private Cat parent2 = null;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parent1, Cat parent2)
        {
            this.name = name;
            this.parent1 = parent1;
            this.parent2 = parent2;
        }

        @Override
        public String toString()
        {
            if ((this.parent1 == null) &&(this.parent2 == null))
                return "Cat name is " + name + ", no mother, no father";
            else if ((parent1 == null) && (parent2 != null))
                return "Cat name is " + name + ", mother is " + parent2.name + ", no father";
            else if ((parent1 != null) && (parent2 == null))
                return "Cat name is " + name + ", no mother, father is " + this.parent1.name;
            else
                return "Cat name is " + name + ", mother is " + this.parent2.name + ", father is " + this.parent1.name;
        }
    }

}
