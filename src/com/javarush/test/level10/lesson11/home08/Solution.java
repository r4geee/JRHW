package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести на их экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] arOfStrLst = new ArrayList[10];
        for (int i = 0; i <10; i++)
        {
            ArrayList<String> tempList = new ArrayList<String>();
            for (int y = 0; y <10; y++)
            {
                tempList.add("Lolo" + i + y);
            }
            arOfStrLst[i] = tempList;
        }

        return arOfStrLst;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}