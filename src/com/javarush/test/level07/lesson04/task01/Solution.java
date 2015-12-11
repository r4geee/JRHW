package com.javarush.test.level07.lesson04.task01;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }
    public static int[] initializeArray() throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i<array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }
        return array;
    }

    public static int max(int[] array) {
        //find the max value here - найдите максимальное значение в этом методе
        int localMax = array[0];
        for (int i = 1;i<20;i++)
        {
            if (array[i] > localMax)
                localMax = array[i];
        }
        return localMax;
    }
}
