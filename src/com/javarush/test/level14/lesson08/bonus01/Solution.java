package com.javarush.test.level14.lesson08.bonus01;

import java.io.EOFException;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new RuntimeException();
        }
        catch (RuntimeException e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IOException();
        }
        catch (IOException e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new CertificateException();
        }
        catch (CertificateException e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new EOFException();
        }
        catch (EOFException e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new ArithmeticException();
        }
        catch (ArithmeticException e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new ArrayStoreException();
        }
        catch (ArrayStoreException e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }

    }
}
