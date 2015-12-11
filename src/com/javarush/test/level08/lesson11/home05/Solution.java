package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Пример ввода:
мама     мыла раму.
Пример вывода:
Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        input = firstLetterToUppercase(input);


        System.out.println(input);
    }

    public static String firstLetterToUppercase (String input)
    {
        for (int i = 0; i < input.length(); i++ )
        {
            Character chrObject = input.charAt(i);
            if(i == 0 && chrObject != ' ')
            {
                String sChanged = Character.toUpperCase(chrObject) + input.substring(i+1);
                input = new String (sChanged);
            }

            else if (chrObject == ' ' && i != input.length()-1)
            {
                chrObject = input.charAt(i+1);
                String sChanged = input.substring(0,i+1)+ Character.toUpperCase(chrObject) + input.substring(i+2);
                input = new String (sChanged);
            }

        }
        return input;
    }


}
