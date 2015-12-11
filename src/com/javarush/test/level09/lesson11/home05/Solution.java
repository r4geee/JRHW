package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String line1 = new String();
        String line2 = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        for (int i = 0; i < input.length(); i++)
        {
            char chr = input.charAt(i);
            if (isVowel(chr))
            {
                if (line1.isEmpty())
                    line1 = line1 + chr;
                else
                    line1 = line1 + " " + chr;
            }

            else if (isVowel(chr)== false && chr != ' ')
            {
                if (line2.isEmpty())
                    line2 = line2 + chr;
                else
                    line2 = line2 + " " + chr;
            }
        }
        System.out.println(line1);
        System.out.println(line2);
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
