package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    public String quickInfo = new String();

    public void initialize(String name)
    {
        this.quickInfo = name;
    }

    public void initialize(String name, int age)
    {
        this.quickInfo = name + " " + age;
    }

    public void initialize(String name, int age, char sex)
    {
        this.quickInfo = name + " " + age + " " + sex;
    }


}
