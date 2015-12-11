package com.javarush.test.level26.lesson02.task01;

import java.util.*;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution
{
    public static Integer[] sort(Integer[] array)
    {
        if (array.length == 0 || array.length == 1)
        {
            return array.clone();
        }
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list);
        final double median;
        if ((list.size() % 2) == 1)
        {
            median = list.get((list.size() - 1) / 2);
        } else
        {
            median = (double)(list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
        }
        Collections.sort(list, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double result = (o2 - median) + (o1 - median);
                if (result == 0)
                {
                    result = o1 - o2;
                }
                return (int) result;
            }
        });
        return list.toArray(new Integer[list.size()]);

    }

    public static void main(String[] args)
    {
        /*Integer[] array1 = {1, 6, 4, 3 ,2 ,5, 0};
        Integer[] array2 = {1, 6, 7, 4, 3 ,2 ,5, 0};*/
        Integer[] array1 = {17, 8, 13, 15, 5};
        // 13, 15, 17, 8, 5
        Integer[] array2 = {5, 8, 15, 17};
        //8, 15, 17, 5
/*        Integer[] array1 = {0, 1, 2};
        Integer[] array2 = {0, 1};*/
        array1 = sort(array1);
        array2 = sort(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
