package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Пример вывода:
12345678
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

        char[] chr = buf.toString().toCharArray();
        char[] chrForm = new char[chr.length];
        int i = 0;
        for(char c : chr)
        {
            if (Character.isDigit(c))
            {
                chrForm[i] = c;
                i++;
            }
        }
        System.out.println(chrForm);

        buf.close();
        stream.close();
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
