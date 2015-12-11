package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {

        PrintStream console = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(buf);

        System.setOut(stream);

        testString.printSomething();

        System.setOut(console);
        String s = buf.toString();
        String result = "";
        String[] lines = s.split(System.lineSeparator());
        for (int i = 0; i < lines.length; i = i + 2)
        {
            if (i != lines.length - 1)
                result = result + lines[i] + System.lineSeparator() + lines[i + 1] + System.lineSeparator() + "JavaRush - курсы Java онлайн" + System.lineSeparator();
            else
                result = result + lines[i] + System.lineSeparator();
        }

        System.out.println(result);

        buf.close();
        stream.close();
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
