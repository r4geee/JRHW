package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
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

        String result = buf.toString().toUpperCase();
        System.out.println(result);

        buf.close();
        stream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }


}
