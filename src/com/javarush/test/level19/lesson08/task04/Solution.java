package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {

        PrintStream console = System.out;

        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(buf);

        System.setOut(stream);

        testString.printSomething();

        System.setOut(console);

        String[] splitted = buf.toString().split(" ");
        int a = Integer.parseInt(splitted[0]);
        int b = Integer.parseInt(splitted[2]);
        String action = splitted[1];
        int result = 0;
        if(action.equals("+"))
            result = a + b;
        else if (action.equals("-"))
            result = a - b;
        else if (action.equals("*"))
            result = a * b;
        System.out.println(a + " " + action + " " + b + " = " + result);

        buf.close();
        stream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 * 6 = ");
        }
    }
}

