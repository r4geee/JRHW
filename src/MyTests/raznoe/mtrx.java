package MyTests.raznoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by r4geee on 21.11.2014.
 */
public class mtrx
{
    public static int[][] matrix = {
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 1}
    };
    public static int width = matrix[0].length;
    public static int height = matrix.length;


    public static void main(String[] args)
    {
        print();
        test2();
        print();
    }

    public static void print()
    {
        for(int i = 0; i < width; i++)
        {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (matrix[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("X");
            }
            System.out.println();
        }
    }

    public static void test1()
    {
        int[][] array = new int[6][5];
        array[2][4] = 1;
        for (int y = 0; y < array.length; y++)
        {
            for (int i = 0; i < array[y].length; i++)
            {
                System.out.print(array[y][i]);
            }
            System.out.println();
        }
    }

    public static void test2()
    {

        //Например так:
        //Создаем список для хранения линий
        //Копируем все непустые линии в список.
        //Добавляем недостающие строки в начало списка.
        //Преобразуем список обратно в матрицу

        List<int[]> lines = new ArrayList<>();

        for (int i = 0; i < height; i++)
        {
            boolean lineIsFull = true;
            for (int j = 0; j < width; j++)
            {
                if (matrix[i][j] != 0)
                    continue;
                else
                {
                    lineIsFull = false;
                    break;
                }
            }
            if (!lineIsFull)
                lines.add(matrix[i]);
        }
        while (lines.size() < height)
            lines.add(0, new int[width]);
        for (int i = 0; i < height; i++)
            matrix[i] = lines.get(i);
    }
}
