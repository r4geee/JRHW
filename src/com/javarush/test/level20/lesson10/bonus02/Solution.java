package com.javarush.test.level20.lesson10.bonus02;

import java.util.ArrayList;

import java.util.List;


/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
/*        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };*/
        byte[][] a = new byte[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        byte[][] b = new byte[][]{
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };
        byte[][] c = new byte[][]{
                {0, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 1}
        };
/*        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");*/
        int countA = getRectangleCount(a);
        int countB = getRectangleCount(b);
        int countC = getRectangleCount(c);
        System.out.println("count = " + countA + ". Должно быть 0");
        System.out.println("count = " + countB + ". Должно быть 2");
        System.out.println("count = " + countC + ". Должно быть 3");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        List<String> checkedPoints = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
        {
            for (int y = 0; y < a[0].length; y++)
            {
                if(i == 0 && y == 0)
                {
                    if (a[i][y] == 1 && !(pointsAlreadyChecked(checkedPoints, i+1, y) || pointsAlreadyChecked(checkedPoints, i, y+1)))
                    {
                        count++;
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                    else if (a[i][y] == 1 && (pointsAlreadyChecked(checkedPoints, i+1, y) || pointsAlreadyChecked(checkedPoints, i, y+1)))
                    {
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                }
                else if (i !=0 && i != a.length-1 && y == 0)
                {
                    if (a[i][y] == 1 && !(pointsAlreadyChecked(checkedPoints, i + 1,y) || pointsAlreadyChecked(checkedPoints, i - 1,y) || pointsAlreadyChecked(checkedPoints, i, y + 1)))
                    {
                        count++;
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                    else if (a[i][y] == 1 && (pointsAlreadyChecked(checkedPoints, i + 1,y) || pointsAlreadyChecked(checkedPoints, i - 1,y) || pointsAlreadyChecked(checkedPoints, i, y + 1)))
                    {
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                }
                else if (i == a.length-1 && y == 0)
                {
                    if (a[i][y] == 1 && !(pointsAlreadyChecked(checkedPoints, i-1, y) || pointsAlreadyChecked(checkedPoints, i, y+1)))
                    {
                        count++;
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                    else if (a[i][y] == 1 && (pointsAlreadyChecked(checkedPoints, i-1, y) || pointsAlreadyChecked(checkedPoints, i, y+1)))
                    {
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                }
                else if (i == 0 && y!= 0 && y != a[0].length-1 )
                {
                    if (a[i][y] == 1 && !(pointsAlreadyChecked(checkedPoints, i + 1,y) || pointsAlreadyChecked(checkedPoints, i, y + 1) || pointsAlreadyChecked(checkedPoints, i, y - 1)))
                    {
                        count++;
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                    else if (a[i][y] == 1 && (pointsAlreadyChecked(checkedPoints, i + 1,y) || pointsAlreadyChecked(checkedPoints, i, y + 1) || pointsAlreadyChecked(checkedPoints, i, y - 1)))
                    {
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                }
                else if (i !=0 && i != a.length-1 && y!= 0 && y != a[0].length-1)
                {
                    if (a[i][y] == 1 && !(pointsAlreadyChecked(checkedPoints, i + 1,y) || pointsAlreadyChecked(checkedPoints, i - 1,y) || pointsAlreadyChecked(checkedPoints, i, y + 1) || pointsAlreadyChecked(checkedPoints, i, y - 1)))
                    {
                        count++;
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                    else if (a[i][y] == 1 && (pointsAlreadyChecked(checkedPoints, i + 1,y) || pointsAlreadyChecked(checkedPoints, i - 1,y) || pointsAlreadyChecked(checkedPoints, i, y + 1) || pointsAlreadyChecked(checkedPoints, i, y - 1)))
                    {
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                }
                else if (i == a.length-1 && y!= 0 && y != a[0].length-1)
                {
                    if (a[i][y] == 1 && !(pointsAlreadyChecked(checkedPoints, i - 1,y) || pointsAlreadyChecked(checkedPoints, i, y + 1) || pointsAlreadyChecked(checkedPoints, i, y - 1)))
                    {
                        count++;
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                    else if (a[i][y] == 1 && (pointsAlreadyChecked(checkedPoints, i - 1,y) || pointsAlreadyChecked(checkedPoints, i, y + 1) || pointsAlreadyChecked(checkedPoints, i, y - 1)))
                    {
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                }
                else if (i == 0 && y == a[0].length-1 )
                {
                    if (a[i][y] == 1 && !(pointsAlreadyChecked(checkedPoints, i + 1,y) || pointsAlreadyChecked(checkedPoints, i, y - 1)))
                    {
                        count++;
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                    else if (a[i][y] == 1 && (pointsAlreadyChecked(checkedPoints, i + 1,y) || pointsAlreadyChecked(checkedPoints, i, y - 1)))
                    {
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                }
                else if (i !=0 && i != a.length-1 && y == a[0].length-1 )
                {
                    if (a[i][y] == 1 && !(pointsAlreadyChecked(checkedPoints, i + 1,y) || pointsAlreadyChecked(checkedPoints, i - 1,y) || pointsAlreadyChecked(checkedPoints, i, y - 1)))
                    {
                        count++;
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                    else if (a[i][y] == 1 && (pointsAlreadyChecked(checkedPoints, i + 1,y) || pointsAlreadyChecked(checkedPoints, i - 1,y) || pointsAlreadyChecked(checkedPoints, i, y - 1)))
                    {
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                }
                else if (i == a.length-1 && y == a[0].length-1 )
                {
                    if (a[i][y] == 1 && !(pointsAlreadyChecked(checkedPoints, i-1, y) || pointsAlreadyChecked(checkedPoints, i, y-1)))
                    {
                        count++;
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                    else if (a[i][y] == 1 && (pointsAlreadyChecked(checkedPoints, i-1, y) || pointsAlreadyChecked(checkedPoints, i, y-1)))
                    {
                        checkedPoints.add(String.format("%d %d", i, y));
                    }
                }

            }
        }
        return count;
    }

    public static boolean pointsAlreadyChecked(List<String> checkedPoints, int i, int y)
    {
        if (checkedPoints.contains(String.format("%d %d", i,y)))
        {
            return true;
        }
        else
            return false;
    }
}
