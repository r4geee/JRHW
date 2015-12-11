package com.javarush.test.level08.lesson08.task02;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        Integer[] intCol = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        HashSet<Integer> set = new HashSet<Integer>();
        Collections.addAll(set, intCol);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThen10(HashSet<Integer> set)
    {
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext())
        {
            Integer a = iterator.next();
            if(a > 10)
            iterator.remove();
        }
        return set;
    }

    public static void main(String[] args)
    {
        HashSet<Integer> set = createSet();
        HashSet<Integer> newSet = removeAllNumbersMoreThen10(set);
        for (Integer i : newSet)
            System.out.println(i);
    }
}
