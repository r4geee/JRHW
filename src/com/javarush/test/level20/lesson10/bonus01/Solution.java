package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        //int[] resultTemp = new int[N];
        //int resultIndex = 0;
        List<Integer> resultTempList = new ArrayList<>();


        for (int i = 0; i < N; i++)
        {
            //разкладываем
            int number = i;
            int numberTemp = number;
            int numberOfDigits = 0;
            while (numberTemp != 0)
            {
                numberTemp = numberTemp / 10;
                numberOfDigits++;
            }
            int[] numberArray = new int[numberOfDigits];
            for(int y = 0; y < numberArray.length;y++)
            {
                numberArray[y] = number % 10;
                number = number / 10;
            }

            //начинаем проверять
            int splittedNumberSum = 0;
            for(int y = 0; y < numberArray.length; y++)
            {
                int plus = 1;
                for (int k = 0; k < numberArray.length;k++)
                {
                    plus = plus * numberArray[y];
                }
                splittedNumberSum += plus;
            }

            if (splittedNumberSum == i && splittedNumberSum != 0)
            {
                resultTempList.add(i);
            }
        }

        int resultSize = resultTempList.size();
        int[] result = new int[resultSize];

        for (int i = 0; i < result.length;i++)
        {
            result[i] = resultTempList.get(i);
        }
        return result;
    }

    public static void main(String[] args)
    {
        //long memoryStart = Runtime.getRuntime().freeMemory();
        long t0 = System.currentTimeMillis();
        //int[] result = getNumbers((int) Math.pow(10,8));
        int[] result = getNumbers(100_000_000);
        //int[] result = getNumbers(100_000);
        long t1 = System.currentTimeMillis();
        long memoryEnd = Runtime.getRuntime().freeMemory();
        //long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(t1-t0);
        System.out.println(memoryEnd);


    }
}
