package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, String value, int n)
    {
        System.out.println(m + n + value);
    }

    public static void printMatrix(String value, int m, int n)
    {
        System.out.println(m + n + value);
    }

    public static void printMatrix(char value, int m, int n)
    {
        System.out.println(m + n + value);
    }

    public static void printMatrix(String value, float m, int n)
    {
        System.out.println(m + n + value);
    }

    public static void printMatrix(String value, int m, double n)
    {
        System.out.println(m + n + value);
    }

    public static void printMatrix(String value, float m, double n)
    {
        System.out.println(m + n + value);
    }

    public static void printMatrix(String value, int m, int n, float d)
    {
        System.out.println(m + n + value + d);
    }

    public static void printMatrix(int m, int n, int d)
    {
        System.out.println(m + n + d);
    }
}
