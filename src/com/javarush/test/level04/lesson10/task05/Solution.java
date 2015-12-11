package com.javarush.test.level04.lesson10.task05;

/* Таблица умножения
Вывести на экран таблицу умножения 10х10 используя цикл while. Числа разделить пробелом.
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

/*        //Напишите тут ваш код
        int i = 1;
        int a = 1;
        int y;
        while (i <= 100)
        {
            y = 1;
            while (y <= 10)
            {
                System.out.print((y*a) + " ");
                y++;
                i++;
            }
            System.out.println(" ");
            a++;
        }*/
        int i = 1;
        int y = 1;
        while (i <= 10)
        {
            while (y <= 10)
            {
                System.out.print(i * y + " ");
                y++;
            }
            System.out.println();
            y = 1;
            i++;
        }
    }
}
