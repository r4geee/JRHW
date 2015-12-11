package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private int top;
    private int left;
    private int width;
    private int height;

    public void initialize(int left, int top, int width, int height)
    {
        this.left = left;
        this.top = top;
        this.height = height;
        this.width = width;
    }

    public void initialize(int left, int top)
    {
        this.left = left;
        this.top = top;
        this.height = 10;
        this.width = 15;
    }

    public void initialize(int left, int top, int width)
    {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = width;
    }

    public void initialize(Rectangle rect2)
    {
        this.top = rect2.top;
        this.left = rect2.left;
        this.width = rect2.width;
        this.height = rect2.height;
    }
}
