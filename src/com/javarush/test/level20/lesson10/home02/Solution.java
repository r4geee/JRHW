package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable
{
    public static final long serialVersionUID = 3L;
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException
    {

        Object object = objectStream.readObject();
        if (object instanceof B)
        {
            B b = (B) object;
            return b;
        }
        else
        {
            A a = (A) object;
            return a;
        }
    }

    public class A implements Serializable
    {
        public static final long serialVersionUID = 1L;
    }

    public class B extends A {
        public static final long serialVersionUID = 2L;
        public B() {
            System.out.println("inside B");
        }
    }
}
