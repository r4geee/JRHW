package com.javarush.test.level09.lesson02.task04;

/* Стек-трейс длиной 10 вызовов
Напиши код, чтобы получить стек-трейс длиной 10 вызовов.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static StackTraceElement[] method1()
    {
        StackTraceElement[] stackTraceElements = method2();
        return stackTraceElements;
    }

    public static StackTraceElement[] method2()
    {
        StackTraceElement[] stackTraceElements = method3();
        return stackTraceElements;

    }

    public static StackTraceElement[] method3()
    {
        StackTraceElement[] stackTraceElements = method4();
        return stackTraceElements;

    }

    public static StackTraceElement[] method4()
    {
        StackTraceElement[] stackTraceElements = method5();
        return stackTraceElements;

    }

    public static StackTraceElement[] method5()
    {
        StackTraceElement[] stackTraceElements = method6();
        return stackTraceElements;

    }

    public static StackTraceElement[] method6()
    {
        StackTraceElement[] stackTraceElements = method7();
        return stackTraceElements;

    }

    public static StackTraceElement[] method7()
    {
        StackTraceElement[] stackTraceElements = method8();
        return stackTraceElements;

    }

    public static StackTraceElement[] method8()
    {
        StackTraceElement[] stackTraceElements = method9();
        return stackTraceElements;

    }

    public static StackTraceElement[] method9()
    {
        StackTraceElement[] stackTraceElements = method10();
        return stackTraceElements;
    }

    public static StackTraceElement[] method10()
    {
        return Thread.currentThread().getStackTrace();
    }
}
