package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(int i=0;i<32;i++)
        {
            alphabet.add( (char) ('а'+i));
        }
        alphabet.add(6,'ё');

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++)
        {
            String s = reader.readLine();
            list.add( s.toLowerCase());
        }

        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        for (int i = 0; i < alphabet.size(); i++)
        {
            result.put(alphabet.get(i), 0);
        }

        for (Character c : alphabet)
        {
            for (String s : list)
            {
                for (int i = 0; i < s.length();i++)
                {
                    Character cTemp = s.charAt(i);
                    if(cTemp.equals(c))
                    {
                        result.put(c, result.get(c) + 1);
                    }

                }
            }
        }
        for (int i = 0; i < alphabet.size(); i++)
        {
            System.out.println(alphabet.get(i) + " " + result.get(alphabet.get(i)));
        }
    }

}
